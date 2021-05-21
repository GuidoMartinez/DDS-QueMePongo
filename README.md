
# Comentarios sobre el diseño | **Iteracion 4**

Se indica requerimiento y comentario sobre la implementacion del mismo

```
Como usuarie de QuéMePongo, quiero poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes
``` 

Se toma como "servicio externo" la APIAccuWeather provista. Se parsea la respuesta y se definen 2 metodos para obtener la temperatura y la probabilidad de precipitaciones. 
Entiendo que se puede crear una abstraccion "Clima" o "Condiciones climaticas" para tener ambos atributos en la misma clase, en este caso no implemente la misma ya que para los requerimientos restantes unicamente es necesaria la temperatura. Por este motivo la utilice como un Double para simplificar.

```
Como usuarie de QuéMePongo, quiero poder recibir sugerencias de atuendos que tengan una prenda para cada categoría, aunque a futuro podrán tener más (Ej.: Una remera, un pantalón, zapatos y un gorro).
```

No implemente una abstraccion Sugerencia, reutilizando el Atuendo. No me queda claro que atributos/comportamiento adicional tendria la sugerencia por si sola. 

Para la creacion de la misma implemente un metodo de manera basica que toma una lista de prendas y validando por Categoria genere un Atuendo segun el contenido de la lista de manera aleatoria en cada parte del Atuendo. Contempla una sola prenda por Prenda/Categoria. Se simplifica ya que no aplica la iteracion 3. Para cumplir el requerimiento deberian pasarse los atributos a Listas<Prenda> y utilizar combinatoria por ej para obtener las opciones posibles "combinables logicamente" (por ej, no ponerse 3 buzos sin remeras). En resumen, no se implementa por complejidad.

```
Como usuarie de QuéMePongo, quiero que al generar una sugerencia las prendas sean acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada. (Ej.: “Remera de mangas largas” no es apta a más de 20°C)
```

Se agrega atributo TemperaturaMaxima en Prenda para utilizarla luego en la creacion de la Sugerencia/Atuendo.
Se implementa clase GenerarSugerencia la cual tiene la logica para obtener la temperatura actual de un SerivicioClima y generar el Atuendo/Sugerencia filtrando aquellos que cumplan con la restriccion de temperaturaMaxima. Como comente previamente, si varias prendas para la misma Categoria respetan esta condicion, se elige aleatoriamente alguna de ellas.


```
Como administradore de QuéMePongo, quiero poder configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas.
```
Se implementa clase "ServicioClima", el cual tiene como dependencia un ProveedorClima, el cual permite inyectar distintos proveedores de clima. Se valida que siempre tenga uno asignado (validacion en constructor + setter).

```
Como stakeholder de QuéMePongo, quiero poder asegurar la calidad de mi aplicación sin incurrir en costos innecesarios. 
```

Se testea aparte la conexion con el servicio de clima. Para el testeo de generarSugerencias por ej que requiere info de algun proveedor de clima se mockea la respuesta con mockito para no pegarle a la API real en los test.




----------------------------------------------
----------------------------------------------




# Comentarios sobre el diseño | **Iteracion 2**

 1. El repositorio de BorradoresIncompletos se crea bajo un Singleton unicamente para cumplir con el siguiente requerimiento:
```
Como usuarie de QuéMePongo, quiero guardar un borrador de la última prenda que empecé a cargar para continuar después.
```
En la siguiente iteracion, en caso de exitir un Usuario, se podria guardar en lista del mismo. Por el momento al no necesitar testear el Repositorio de borradoresPrenda, no me genera inconvenientes el patron utilizado.

 2. El siguiente requerimiento se cumple controlando el momento de la creacion de la prenda a traves del prenda.BorradorPrenda por medio de la UI:
```
 Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.
```

 3. Entiendo que apunta a los predefinidos en el enunciado (San Juan y Johnson), en caso de requerir armar nuevos uniformes en base a las prendas cargadas, no especifica si hay algun criterio o se deben elegir aleatoriamente una de cada tipo (superior, inferior, calzado) de un grupo/repo de prendas ya creadas. Se cubre el requerimiento solo en el primer caso.
```
Como usuario QueMePongo, quiero que poder recibir sugerencias de uniformes armados.
```