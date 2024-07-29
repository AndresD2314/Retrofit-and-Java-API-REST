# People Management App

Este es un proyecto de ejemplo para gestionar personas utilizando un backend en Java con Spring Boot y una aplicación móvil en Android. La aplicación móvil se comunica con el backend a través de Retrofit y sigue el patrón de arquitectura MVVM (Model-View-ViewModel).

## Características

- Crear, leer, actualizar y eliminar (CRUD) personas.
- Utiliza Retrofit para las solicitudes HTTP.
- Arquitectura MVVM con LiveData y ViewModel.
- Interfaz de usuario utilizando RecyclerView para mostrar la lista de personas.
- Manejo de errores y confirmación de eliminación mediante AlertDialog.

## Requisitos

- Android Studio
- JDK 17 o superior
- Gradle
- Maven
- Conexión a internet

## Configuración del Backend

1. Clona el repositorio donde se encuentra tanto el backend como el frontend:

   ```bash
   git clone https://github.com/AndresD2314/Retrofit-and-Java-API-REST.git
   
## Estructura del proyecto
El backend está construido con Spring Boot y proporciona una API REST para gestionar personas. Las rutas principales son:

- GET /api/v1/people - Obtener todas las personas.
- GET /api/v1/people/{id} - Obtener una persona por ID.
- POST /api/v1/people - Crear una nueva persona.
- PUT /api/v1/people/{id} - Actualizar una persona existente.
- DELETE /api/v1/people/{id} - Eliminar una persona.

## Uso de la Aplicación

### Pantalla Principal:

- Botón "Crear" para abrir la actividad de creación de una nueva persona.
- Botón "Ver todas las personas" para abrir la actividad que muestra la lista de personas.

### Crear Persona:

1. Rellena los campos de nombre, edad, correo y número de celular.
2. Pulsa el botón "Enviar" para crear la persona.
3. Aparecerá un mensaje de confirmación y regresarás a la pantalla principal.

### Actualizar Persona:

1. En la lista de personas, pulsa el botón de editar para abrir la actividad de actualización.
2. Modifica los datos necesarios y pulsa el botón "Actualizar".
3. Aparecerá un mensaje de confirmación y regresarás a la pantalla principal.

### Eliminar Persona:

1. En la lista de personas, pulsa el botón de eliminar.
2. Aparecerá un diálogo de confirmación. Si confirmas, la persona será eliminada.


