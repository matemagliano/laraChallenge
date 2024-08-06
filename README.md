# Lara Challenge

## Descripción

API para contactar colaboradores vía Slack v0.1 y hacerles un set de preguntas, con persistencia de respuestas para métricas.

## Requerimientos

- JDK 17
- Maven

## Instrucciones para Ejecutar

1. Instalar JDK 17.
2. En la consola `cd` a esta carpeta
4. Ejecutar el archivo JAR:
    ```
    java -jar dist/myapp-0.0.1-SNAPSHOT.jar
    ```
5. La API estará en `http://localhost:8081`.

### Endpoints

#### Crear Conversación

- **URL**: `/api/conversacion/create`
- **Método**: `POST`
- **Descripción**: Crea una nueva conversación con un conjunto de preguntas para un empleado específico.
- **Request Body**:
    ```json
    {
      "employeeId": "1",
      "preguntaIds": ["1", "2", "3"]
    }
    ```
    - `employeeId` (string): ID del empleado.
    - `preguntaIds` (array of strings): IDs de las preguntas.