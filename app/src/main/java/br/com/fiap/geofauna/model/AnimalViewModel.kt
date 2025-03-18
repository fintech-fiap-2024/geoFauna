package br.com.fiap.geofauna.model

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
                        vernacularName = animalResult.vernacularName,
                        kingdom = animalResult.kingdom,
                        phylum = animalResult.phylum,
                        order = animalResult.order,
                        family = animalResult.family,
                        species = animalResult.species,
                        media = animalResult.media ?: emptyList(),  // Verifique se media é null
                        decimalLatitude = animalResult.decimalLatitude,
                        decimalLongitude = animalResult.decimalLongitude
                    )
                    _animalInfo.value = animal
                } else {
                    _error.value = "Resultado não encontrado"
                }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
