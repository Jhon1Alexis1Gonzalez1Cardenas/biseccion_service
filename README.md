# Biseccion Service — Uso (POST)

Endpoint
- Método: POST  
- URL: `http://localhost:9090/api/biseccion_service/Evaluar`  
- Header: `Content-Type: application/json`

Cuerpo (ejemplo para Postman o curl):
```json
{
  "x1": "1",
  "x2": "2",
  "funcion": "(x^2)cos(x)"
}
```
También puede enviar números sin comillas:
```json
{
  "x1": 1.0,
  "x2": 2.0,
  "funcion": "(x^2)cos(x)"
}
```

Respuesta esperada
- El microservicio devuelve un arreglo `double[]` con 3 posiciones:
  1. raíz (ej.: `1.5707963267341256`)
  2. iteraciones realizadas (ej.: `30.0`)
  3. código de error (ej.: `0.0` = sin error)

Ejemplo de respuesta:
```json
[1.5707963267341256, 30.0, 0.0]
```

Cómo recibir y procesar la respuesta (ejemplo en Java)
- El arreglo que devuelve el microservicio se guarda en un arreglo local llamado `arreglo`. A partir de ese arreglo se extraen las variables:
```java
// Ejemplo usando RestTemplate
RestTemplate rest = new RestTemplate();
String url = "http://localhost:9090/api/biseccion_service/Evaluar";

Map<String,Object> request = new HashMap<>();
request.put("x1", "1");
request.put("x2", "2");
request.put("funcion", "(x^2)cos(x)");

// Se recibe el arreglo que devuelve el servicio en el arreglo local
double[] arreglo = rest.postForObject(url, request, double[].class);

// Extraer valores correctamente:
double raiz = arreglo[0];
int iteraciones = (int) arreglo[1];
int codigo = (int) arreglo[2]; // <- usar índice 2 para el código de error

// Validar código antes de usar la raíz
if (codigo != 0) {
    // Aquí obtener el mensaje de error según el código:
    // - Usar errores.properties de la librería (si se importa)
    // - O crear una clase con constantes que mapee código -> mensaje
    System.err.println("Error código: " + codigo + " -> mensaje asociado");
    return; // terminar proceso según su flujo
}

// Si codigo == 0: usar raiz e iteraciones
System.out.println("Raíz: " + raiz + ", Iteraciones: " + iteraciones);
```

Notas
- Asegúrese de que el servicio esté corriendo en el puerto 9090.
- Si importa mensajes de error desde la librería de bisección:
  - Revise https://github.com/Jhon1Alexis1Gonzalez1Cardenas/metodo_biseccion
  - O copie los valores de errores.properties y cree una clase con constantes para mapear códigos a mensajes.
- Este README es el único archivo de instrucciones para llamar y procesar la API.
- nota a ultma hora(24/11/2025): acabe de coolocar el archivo errores.properties en el proyecto, para que puedan importar los mensajes de error aqui en el repositorio en una carpeta llamada recursos.