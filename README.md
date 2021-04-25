# Comentarios sobre el diseño Iteracion 2

 1. El repositorio de BorradoresIncompletos bajo un Singleton unicamente se crea para cumplir con el siguiente requerimiento:
```
Como usuarie de QuéMePongo, quiero guardar un borrador de la última prenda que empecé a cargar para continuar después.
```
En la siguiente iteracion, en caso de exitir un Usuario, se podria guardar en lista del mismo. Por el momento al no necesitar testear el Repositorio de borradoresPrenda, no me genera inconvenientes el Singleton. 

 2. El siguiente requerimiento se cumple controlando el momento de la creacion de la prenda a traves del BorradorPrenda por medio de la UI:
```
 Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.
```

