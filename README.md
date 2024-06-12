# Proyecto Android: Llamadas a API con Retrofit, Dagger 2 y SharedPreferences

Este proyecto Android consume una API utilizando Retrofit, Dagger 2 para la inyección de dependencias y SharedPreferences para la persistencia de datos.

Funcionalidades:

    Realiza llamadas a una API externa.
    Muestra datos de usuarios, álbumes, portadas y detalles de usuarios.

Tecnologías:

    Retrofit: Librería para realizar peticiones HTTP asíncronas.
    Dagger 2: Framework para inyección de dependencias.
    SharedPreferences: Mecanismo para almacenar datos clave-valor de forma persistente.

Estructura del proyecto:

    app/src/main/java:
        com.sfr.practicas_signlab: Contiene las clases del proyecto, incluyendo:
            Interfaz API: Define los métodos para realizar las llamadas a la API.
            Modelo de datos: Representa las entidades devueltas por la API.
            Interactors: Implementa las operaciones de acceso a datos, utilizando Retrofit y SharedPreferences.
            Presenters: Exponen los datos y la lógica de negocio a la vista.
            Views (Activity/Fragments): Muestra la interfaz de usuario y consume los datos del Presenter.
    app/src/main/res:
        layouts: Contiene los diseños de la interfaz de usuario.

Configuración:

    Clona el repositorio o descarga el proyecto.
    Abre el proyecto en Android Studio.
    Configura tu API key en el archivo app/src/main/java/utils/Constantes.java.
    Ejecuta la aplicación en un dispositivo Android o emulador.

Uso:

    Abre la aplicación.
    Inicia sesion con user user.
    Se reedirigirá a Home.java, que contendrá una barra de navegación inferior con las pestañas Usuario, Álbunes y Portadas.

Para ver la versión de Kotlin con Jetpack Compose, pulsa [aquí](https://github.com/sergiofrubio/practicas_signlab_android_kotlin_jetpack_compose).

