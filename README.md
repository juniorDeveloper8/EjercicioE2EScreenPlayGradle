# Ejercicio de Automatización E2E con Serenity BDD

Este ejercicio realiza pruebas funcionales automatizadas (E2E) de un flujo de compra en la
página [https://www.demoblaze.com/](https://www.demoblaze.com/) utilizando Serenity BDD con Screenplay en Java y Maven.

## Prerequisitos

Antes de ejecutar las pruebas, asegúrate de tener configurado lo siguiente en tu máquina local:

|                                                                               **IntelliJ**                                                                                |                                                              **Java**                                                               |                                                         **Gradle**                                                         |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------:|
| [<img width="50" height="50" src="https://cdn.iconscout.com/icon/free/png-128/intellij-idea-569199.png">](https://www.jetbrains.com/es-es/idea/download/#section=windows) | [<img height="60" src="https://www.oracle.com/a/ocom/img/cb71-java-logo.png">](https://www.oracle.com/java/technologies/downloads/) | [<img height="50" src="https://gradle.org/images/gradle-knowledge-graph-logo.png?20170228">](https://gradle.org/releases/) |

> **NOTA**:

- **Sistema Operativo:** Windows 11
- **IDE:** IntelliJ IDEA versión Community 2024
- **Gradel**
- **JDK:** versión 17 (debe estar en la variable de entorno)
- Una vez obtenido IntelliJ es necesario instalar los plugins de Gherkin y Cucumber for Java. (
    *[Guia de instalación plugins en intellij](https://www.jetbrains.com/help/idea/managing-plugins.html)*)

## Comandos de instalación

- Clona el repositorio

```markdown
git clone https://github.com/juniorDeveloper8/EjercicioE2EScreenPlayGradle.git
```

### (SOLO SI ES NECESARIO)

- Instala las dependencias del proyecto:

```markdown
./gradlew build
```

- Compilar el proyecto y limpiar:

```markdown
./gradlew clean assemble
```

## Instrucciones para Ejecutar las Pruebas

1. **Ejecuta las pruebas:**
    - Para ejecutar las pruebas, dirigirse a la carpeta runner y ejecutar RunnerTest.java que se encuentra en
    ```
    \src\test\java\com\nttdata\runners\RunnerTest.java
    ```

    2. **Genera el reporte:**
        - una vez ejecutada la prueba nos diriguimos al final de la terminal del intellij donde estara la url del
          reporte

        - Otra forma de ver los reportes es en la carpeta `target/site/serenity` detro estaral el reporte de nuestra
          ejecución el archivo es `index.html` .

# Nota:

## Configuración del Proyecto

### En el archivo de serenity.conf tomar en cuenta las siguientes indicaciones

- En webDrive esta configurado para q funciones con el navegador brave

```
 webdriver {
    driver = chrome
    autodownload = false
    capabilities {
        "goog:chromeOptions" {
        #usar el binario si no tiene instalado chorme
            binary = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
            args = [
                "--remote-allow-origins=*", "--xheadless"
            ]
        }
    }

}
```

- Si usan otro navegador como Chrome, entonces deben comentar el binario o eliminarlo. Les dejo el código:

```
webdriver {
    driver = chrome
    autodownload = false
    capabilities {
        "goog:chromeOptions" {
            args = [
                "--remote-allow-origins=*", "--xheadless"
            ]
        }
    }

}
```

1. **Configurar el entorno:**
    - El archivo `serenity.conf` debe estar configurado correctamente. Asegúrate de que las siguientes configuraciones
      estén presentes:
      ```hocon
      environments {
          default {
              webdriver.base.url = "https://www.demoblaze.com/"
          }
          dev {
              webdriver.base.url = "https://www.demoblaze.com/"
          }
          uat {
              webdriver.base.url = "https://www.demoblaze.com/"
          }
      }
 
      webdriver {
          driver = chrome
          autodownload = false
          capabilities {
              "goog:chromeOptions" {
                  binary = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
                  args = [
                      "--remote-allow-origins=*", "--xheadless"
                  ]
              }
          }
      }
      ```

## Detalles del Flujo de Compra Automatizado

El flujo de compra automatizado incluye los siguientes pasos:

1. **Agregar dos productos al carrito:**
    - La prueba agrega dos productos diferentes al carrito de compras.

2. **Visualizar el carrito:**
    - Una vez que los productos están en el carrito, la prueba visualiza el contenido del carrito.

3. **Completar el formulario de compra:**
    - Se completa el formulario de compra con detalles ficticios.

4. **Finalizar la compra:**
    - La prueba finaliza la compra y verifica que la transacción se haya completado correctamente.
