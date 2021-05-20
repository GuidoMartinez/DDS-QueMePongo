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