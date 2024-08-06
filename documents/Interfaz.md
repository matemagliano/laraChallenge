# API Documentation

## Endpoints

### 1. Crear una Conversación

- **URL:** `/api/conversacion/create`
- **Method:** `POST`
- **Description:** Este endpoint crea una nueva conversación con un conjunto de preguntas para un empleado específico.
- **Request Body:**

    ```json
    {
      "employeeId": "1",
      "preguntaIds": ["1", "2", "3"]
    }
    ```
    - `employeeId` (string): ID del empleado con quien se va a iniciar la conversación.
    - `preguntaIds` (array of strings): IDs de las preguntas que se van a hacer en la conversación.

## Códigos de Respuesta HTTP

- `200 OK`: La solicitud se procesó correctamente.
- `400 Bad Request`: La solicitud es inválida (por ejemplo, falta algún parámetro requerido).
- `404 Not Found`: El recurso solicitado no existe.
- `500 Internal Server Error`: Ocurrió un error en el servidor al procesar la solicitud.