# Challenge Juan Camilo Wong

## Prerequisitos

- Maven.

- MySQL en puerto 3306.

- Crear esquema _wolox_ en MySQL.

- Configurar usuario y contraseña en __application.properties __ en la ruta _src/main/resources_.

```

spring.datasource.username=

spring.datasource.password=

```

## Info de solución

- Se usó base de datos MySQL para persistir los datos.

- Se agrego en la configuración ddl-auto=create para creación automática de bases de datos.

- Permisos sobre los "Albums" fueron Lectura (R=1), Escritura (W=2), Lectura y Escritura (RW = 3) y Ninguno (N=0)

## URL para acceso

La aplicación esta configurada por defecto en puerto __8080__, cada una obtiene una lista de los datos con las rutas por defecto, ademas obtiene información por individual agregando __/[codigo_id]__.

```

localhost:8080/api/usuarios

localhost:8080/api/usuarios/2

localhost:8080/api/photos

localhost:8080/api/photos/10

localhost:8080/api/comments

localhost:8080/api/comments/3

localhost:8080/api/albums

localhost:8080/api/albums/5

```

## Funcionalidades

1. Para registrar un álbum compartido con un usuario y sus permisos se usa lo siguiente:

Método:

```

POST

```

Ruta:

```

localhost:8080/api/permissions/add

```

Parámetros:

```

{

"userId" : 1,

"albumId" : 100,

"permissionValue" : 3

}

```

2. Para cambiar los permisos de un usuario, inclusive eliminarlos asignando 0 en permissionsValue :

Método:

```

PUT

```

Ruta:

```

localhost:8080/api/permissions/update

```

Parámetros:

```

{

"userId" : 1,

"albumId" : 100,

"permissionValue" : 3

}

```

3. Para traer todos los usuarios que tienen un permiso determinado respecto a un específico ({albumId} corresponde al id del álbum y {permissionValue} al código del permiso nombrado anteriormente).

Metodo:

```

GET

```

Ruta:

```

localhost:8080/api/permissions/user/album/{albumId}/permission/{permissionValue}

```

4. Para filtrar los comentarios, se puede hacer de 3 formas:

```

localhost:8080/api/comments/filter : Trae todos los comentarios

localhost:8080/api/comments/filter?userId={albumId} : Trae todos los comentarios de un usuario

localhost:8080/api/comments/filter?name={name} : Trae todos los comentarios que tengan el nombre especificado

```
