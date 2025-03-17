package br.com.fiap.geofauna.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.geofauna.service.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnimalViewModel : ViewModel() {
    private val _animalInfo = MutableStateFlow<Animal?>(null)
    val animalInfo: StateFlow<Animal?> = _animalInfo

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun searchAnimalByScientificName(scientificName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = RetrofitInstance.api.searchAnimalByScientificName(scientificName)
                if (response.results.isNotEmpty()) {
                    val animalResult = response.results[0]
                    // Certifique-se de passar uma lista vazia se media for null
                    val animal = Animal(
                        scientificName = animalResult.scientificName,
                        media = animalResult.media ?: emptyList()  // Verifique se media é null
                    )
                    _animalInfo.value = animal
                } else {
                    _error.value = "No results found"
                }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}

//class AnimalViewModel : ViewModel() {
//    private val apiService = RetrofitFactory().getAnimalService()
//
//    fun fetchOccurrences(speciesKey: Int) {
//        viewModelScope.launch {
//            try {
//                val response = apiService.getSpeciesInfo(speciesKey)
//                // Processar a resposta
//            } catch (e: Exception) {
//                // Tratar erro
//            }
//        }
//    }
//}

//class AnimalViewModel : ViewModel() {
//    private val _animalInfo = MutableStateFlow<AnimalService?>(null)
//    val animalInfo: StateFlow<AnimalService?> = _animalInfo
//
//    private val _isLoading = MutableStateFlow(false)
//    val isLoading: StateFlow<Boolean> = _isLoading
//
//    private val _error = MutableStateFlow<String?>(null)
//    val error: StateFlow<String?> = _error
//
//    fun fetchAnimalInfo(speciesKey: Int) {
//        viewModelScope.launch {
//            _isLoading.value = true
//            _error.value = null
//            try {
//                val response = RetrofitFactory().getAnimalService()
//                _animalInfo.value = response
//            } catch (e: Exception) {
//                _error.value = e.message
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
//}