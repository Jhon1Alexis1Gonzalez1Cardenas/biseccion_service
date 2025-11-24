# Biseccion Service — Uso (POST)

Endpoint:
- Método: POST
- URL: `http://localhost:9090/api/biseccion_service/Evaluar`
- Header: `Content-Type: application/json`

Cuerpo (ejemplo que puede usar en Postman o curl):
```json
{
  "x1": "1",
  "x2": "2",
  "funcion": "(x^2)cos(x)"
}
```
(Se aceptan valores numéricos sin comillas: 1.0, 2.0. El campo `funcion` debe ser una cadena con la expresión.)

Ejemplo curl:
```bash
curl -X POST "http://localhost:9090/api/biseccion_service/Evaluar" \
  -H "Content-Type: application/json" \
  -d '{"x1":"1","x2":"2","funcion":"(x^2)cos(x)"}'
```

Respuesta esperada
- El servicio devuelve un arreglo double[] con 3 posiciones:
  1. raíz encontrada (ej.: 1.5707963267341256)
  2. iteraciones realizadas (ej.: 30.0)
  3. código de error (ej.: 0.0 = sin error)

Ejemplo de respuesta:
```json
[1.5707963267341256, 30.0, 0.0]
```

Cómo procesar la respuesta en Java
```java
double[] arreglo = /* parsear body a double[] */;
double raiz = arreglo[0];
int iteraciones = (int) arreglo[1];
int codigo = (int) arreglo[2];

if (codigo != 0) {
    // Obtener mensaje de error:
    // - Usar errores.properties de la librería de bisección:
    //   https://github.com/Jhon1Alexis1Gonzalez1Cardenas/metodo_biseccion
    // - O copiar las constantes y crear una clase con constantes/variables globales
    // Mostrar mensaje y terminar proceso:
    System.err.println("Error código: " + codigo + " -> mensaje asociado");
    return 0;
}

// Si codigo == 0, usar raiz e iteraciones:
System.out.println("Raíz: " + raiz + ", Iteraciones: " + iteraciones);
```

Notas
- Verifique que el microservicio esté corriendo en el puerto 9090.
- Si importa mensajes de error desde la librería externa, asegúrese de incluirla como dependencia o copiar el contenido de errores.properties a una clase de constantes.
- Un único README en la raíz del proyecto es suficiente.