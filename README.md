Conflict Tracker es una API REST que permet gestionar informació
sobre conflictes a nivell mundial. 

Instruccions d'ús:
Instal·lació
- Clona el repositori
- Obrir el projecte
- Executar ConflictTrackerApplication
- L'aplicació estarà disponible a http://localhost:8081

Exemples d'ús:
- Obtenir tots els conflictes:
  GET http://localhost:8081/conflicts
- Obtenir un conflicte per ID:
  GET http://localhost:8081/conflicts/{id}
- Crear un nou conflicte:
  POST http://localhost:8081/conflicts
  Body: {
  "name": "Guerra de Ucrania",
  "startConflict": "2022-02-24",
  "status": "ACTIVE",
  "description": "Conflicte armat iniciat després de la invasió russa d'Ucraïna.",
  "countryId": [1, 2]
  }
- Actualitzar un conflicte:
  PUT http://localhost:8081/conflicts/{id}
- Eliminar un conflicte:
  DELETE http://localhost:8081/conflicts/{id}