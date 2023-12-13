# Árbol binario como índice
---
## Descripción

>El proyecto se centra en optimizar el manejo de información, abordando la eficiencia en la consulta de datos, la metodología empleada implica el uso de un árbol binario para la lecura de un archivo CSV y la consulta de la información contenida. Este enfoque optimizado permite recuperar la información de interés de manera efectiva y rápida, destacando la importancia de la estructura de datos en la eficiencia de la gestión de la información.

>Nombre del alumno 1: **DIEGO GARCIA JENNIFER** (Presentacion)
>Nombre del alumno 2: **MARTINEZ MENDOZA JESUS ANGEL** (Documentación)
>Nombre del alumno 3: **VASQUEZ HERNANDEZ BERNARDO ADONAI** (Ejecución)

>Carrera que cursan: **Ingeniería En Sistemas Computacionales**
>Nombre de la materia: **Estructura De Datos**
>Clave de la materia: **SCD1007**

Competencia de la materia: 

*Conoce, comprende y aplica los algoritmos de búsqueda para el uso adecuado en el desarrollo de aplicaciones que permita solucionar problemas del  entorno*.

Nombre del asesor: **SILVA MARTINEZ DALIA**

---

## UML

````mermaid
classDiagram
  class Dato {
    -nombre_localidad: String
    -nombre_municipio: String
    -poblacion_fem: int
    -poblacion_mas: int
    -latitud: String
    -longitud: String
    +Dato(nombre_localidad: String, nombre_municipio: String, poblacion_fem: int, poblacion_mas: int, latitud: String, longitud: String)
    +getNombre_localidad(): String
    +setNombre_localidad(nombre_localidad: String): void
    +getNombre_municipio(): String
    +setNombre_municipio(nombre_municipio: String): void
    +getPoblacion_fem(): int
    +setPoblacion_fem(poblacion_fem: int): void
    +getPoblacion_mas(): int
    +setPoblacion_mas(poblacion_mas: int): void
    +getLatitud(): String
    +setLatitud(latitud: String): void
    +getLongitud(): String
    +setLongitud(longitud: String): void
  }

  class NodoAvl {
    -posicion: int
    -identifi: int
    -izquierda: NodoAvl
    -derecha: NodoAvl
    -fe: int
    +NodoAvl()
    +NodoAvl(identifi: int, posicion: int)
    +getPosicion(): int
    +setPosicion(posicion: int): void
    +getIdentifi(): int
    +setIdentifi(identifi: int): void
    +getIzquierda(): NodoAvl
    +setIzquierda(izquierda: NodoAvl): void
    +getDerecha(): NodoAvl
    +setDerecha(derecha: NodoAvl): void
    +getFe(): int
    +setFe(fe: int): void
  }

  class ArbolBalanceado {
    -raiz: NodoAvl
    -cont: int
    +ArbolBalanceado()
    +buscar(x: int): NodoAvl
    +insertar(i: int, j: int): boolean
    +inOrden(): void
    +posOrden(): void
    +preOrden(): void
    +size(): int
    +eliminar(o: int, modo: int): boolean
    +getRaiz(): int
    +salvarInOrden(i: int): int
    +salvarPosOrden(i: int): int
    +salvarPreOrden(i: int): int
    +obtenerFe(aux: NodoAvl): int
    +rotacionIzquierda(n: NodoAvl): NodoAvl
    +rotacionDerecha(n: NodoAvl): NodoAvl
    +rotacionDobleIzquierda(n: NodoAvl): NodoAvl
    +rotacionDobleDerecha(n: NodoAvl): NodoAvl
  }

  class ObtencionDatos {
    +procesarDatos(): ArbolBalanceado
    +consultar(posicion: int): Dato
    -tryParseInt(value: String): int
    -obtenerUltimoDigito(numero: int): int
    -obtenerUltimoCaracter(dato: String, pos: int): char
  }

  class Main {
    -arbol: ArbolBalanceado
    +Main()
    +initComponents(): void
    +imprimirDato(textArea: JTextArea, d: Dato): void
  }

Main ..>Dato
Main ..> ObtencionDatos
Main ..> ArbolBalanceado

ObtencionDatos..> ArbolBalanceado
ObtencionDatos..> Dato
ArbolBalanceado ..> NodoAvl

````
---
## API
### NodoAvl

#### Descripción
La clase `NodoAvl` representa un nodo en un árbol AVL, una estructura de datos de árbol de búsqueda binaria balanceada.
#### Campos
| Tipo       | Campo      | Descripción                                   |
|------------|------------|-----------------------------------------------|
| `int`      | `posicion` | Almacena la posición asociada al nodo.        |
| `int`      | `identifi` | Almacena la identificación asociada al nodo.  |
| `NodoAvl`  | `izquierda`| Representa el hijo izquierdo del nodo.        |
| `NodoAvl`  | `derecha`  | Representa el hijo derecho del nodo.          |
| `int`      | `fe`       | Almacena el factor de equilibrio del nodo.   |

#### Constructores
| Constructor                   | Descripción                                                            |
|-------------------------------|------------------------------------------------------------------------|
| `NodoAvl()`                   | Crea un nuevo nodo AVL sin valores iniciales.                           |
| `NodoAvl(int identifi, int posicion)` | Crea un nuevo nodo AVL con identificación y posición especificadas.   |

#### Métodos
| Nombre                 | Tipo de Dato que Retorna | Tipo de dato que Recibe | Descripción |
|------------------------|-------------------------|------------------------|-------------|
| `getPosicion()`        | `int`                   | Ninguno                | Devuelve la posición asociada al nodo. |
| `setPosicion(int posicion)` | `void`              | `int posicion`         | Establece la posición asociada al nodo. |
| `getIdentifi()`        | `int`                   | Ninguno                | Devuelve la identificación asociada al nodo. |
| `setIdentifi(int identifi)` | `void`              | `int identifi`         | Establece la identificación asociada al nodo. |
| `getIzquierda()`       | `NodoAvl`               | Ninguno                | Devuelve el hijo izquierdo del nodo. |
| `setIzquierda(NodoAvl izquierda)` | `void`       | `NodoAvl izquierda`    | Establece el hijo izquierdo del nodo. |
| `getDerecha()`         | `NodoAvl`               | Ninguno                | Devuelve el hijo derecho del nodo. |
| `setDerecha(NodoAvl derecha)` | `void`          | `NodoAvl derecha`      | Establece el hijo derecho del nodo. |
| `getFe()`              | `int`                   | Ninguno                | Devuelve el factor de equilibrio del nodo. |
| `setFe(int fe)`        | `void`                  | `int fe`               | Establece el factor de equilibrio del nodo. |

### Dato

#### Descripción
La clase `Dato` representa un conjunto de datos con información sobre una localidad, incluyendo el nombre de la localidad, el nombre del municipio, la población femenina, la población masculina, la latitud y la longitud.
#### Campos
| Tipo | Campo | Descripción |
|------|-------|-------------|
| `String` | `nombre_localidad` | Almacena el nombre de la localidad. |
| `String` | `nombre_municipio` | Almacena el nombre del municipio. |
| `int` | `poblacion_fem` | Almacena la población femenina. |
| `int` | `poblacion_mas` | Almacena la población masculina. |
| `String` | `latitud` | Almacena la latitud de la localidad. |
| `String` | `longitud` | Almacena la longitud de la localidad. |

#### Constructores
| Constructor | Descripción |
|-------------|-------------|
| `Dato(String nombre_localidad, String nombre_municipio, int poblacion_fem, int poblacion_mas, String latitud, String longitud)` | Crea un nuevo objeto `Dato` con la información proporcionada. |

#### Métodos
| Nombre | Tipo de Dato que Retorna | Tipo de dato que Recibe | Descripción |
|--------|--------|-------------------------|-------------|
| `getNombre_localidad()` | `String` | Ninguno | Devuelve el nombre de la localidad. |
| `setNombre_localidad(String nombre_localidad)` | `void` | `String nombre_localidad` | Establece el nombre de la localidad. |
| `getNombre_municipio()` | `String` | Ninguno | Devuelve el nombre del municipio. |
| `setNombre_municipio(String nombre_municipio)` | `void` | `String nombre_municipio` | Establece el nombre del municipio. |
| `getPoblacion_fem()` | `int` | Ninguno | Devuelve la población femenina. |
| `setPoblacion_fem(int poblacion_fem)` | `void` | `int poblacion_fem` | Establece la población femenina. |
| `getPoblacion_mas()` | `int` | Ninguno | Devuelve la población masculina. |
| `setPoblacion_mas(int poblacion_mas)` | `void` | `int poblacion_mas` | Establece la población masculina. |
| `getLatitud()` | `String` | Ninguno | Devuelve la latitud de la localidad. |
| `setLatitud(String latitud)` | `void` | `String latitud` | Establece la latitud de la localidad. |
| `getLongitud()` | `String` | Ninguno | Devuelve la longitud de la localidad. |
| `setLongitud(String longitud)` | `void` | `String longitud` | Establece la longitud de la localidad. |

Este API representa un conjunto de datos (`Dato`) y proporciona métodos para acceder y modificar sus atributos. La descripción, campos, constructores y métodos siguen la estructura de documentación sugerida en la plantilla de Markdown.


### ArbolBalanceado

#### Descripción
La clase `ArbolBalanceado` implementa un árbol AVL (Árbol de Búsqueda Binaria Balanceado) en Java. Este árbol mantiene el equilibrio automáticamente después de cada operación de inserción o eliminación para garantizar un rendimiento eficiente en la búsqueda.
#### Campos
| Tipo | Campo | Descripción |
|------|-------|-------------|
| `NodoAvl` | `raiz` | Representa la raíz del árbol AVL. |
| `int` | `cont` | Contador utilizado en varias operaciones del árbol. |

#### Constructores
| Constructor | Descripción |
|-------------|-------------|
| `ArbolBalanceado()` | Crea un nuevo árbol AVL vacío. |

#### Métodos
| Nombre | Tipo de Dato que Retorna | Tipo de dato que recibe | Descripción |
|--------|-------------------------|-------------------------|-------------|
| `buscar(int x)` | `NodoAvl` | `int x` | Busca un nodo con el valor `x` en el árbol AVL. Retorna el nodo encontrado o `null` si no se encuentra. |
| `insertar(int i, int j)` | `boolean` | `int i, int j` | Inserta un nuevo nodo con valores `i` y `j` en el árbol AVL. Retorna `true` si la inserción fue exitosa, de lo contrario, retorna `false`. |
| `inOrden()` | `void` | - | Realiza un recorrido inorden del árbol, imprimiendo los valores de los nodos. |
| `posOrden()` | `void` | - | Realiza un recorrido posorden del árbol, imprimiendo los valores de los nodos. |
| `preOrden()` | `void` | - | Realiza un recorrido preorden del árbol, imprimiendo los valores de los nodos. |
| `size()` | `int` | - | Retorna la cantidad de nodos en el árbol. |
| `eliminar(int o, int modo)` | `boolean` | `int o, int modo` | Elimina un nodo con el valor `o` del árbol AVL. Retorna `true` si la eliminación fue exitosa, de lo contrario, retorna `false`. |
| `getRaiz()` | `int` | - | Retorna el valor de la raíz del árbol. |
| `salvarInOrden(int i)` | `int` | `int i` | Salva el nodo en la posición `i` utilizando un recorrido inorden y retorna el valor del nodo salvado. |
| `salvarPosOrden(int i)` | `int` | `int i` | Salva el nodo en la posición `i` utilizando un recorrido posorden y retorna el valor del nodo salvado. |
| `salvarPreOrden(int i)` | `int` | `int i` | Salva el nodo en la posición `i` utilizando un recorrido preorden y retorna el valor del nodo salvado. |
| `obtenerFe(NodoAvl aux)` | `int` | `NodoAvl aux` | Retorna el factor de equilibrio del nodo especificado. |
| `rotacionIzquierda(NodoAvl n)` | `NodoAvl` | `NodoAvl n` | Realiza una rotación simple izquierda en el nodo especificado. Retorna el nuevo nodo raíz después de la rotación. |
| `rotacionDerecha(NodoAvl n)` | `NodoAvl` | `NodoAvl n` | Realiza una rotación simple derecha en el nodo especificado. Retorna el nuevo nodo raíz después de la rotación. |
| `rotacionDobleIzquierda(NodoAvl n)` | `NodoAvl` | `NodoAvl n` | Realiza una rotación doble izquierda en el nodo especificado. Retorna el nuevo nodo raíz después de la rotación. |
| `rotacionDobleDerecha(NodoAvl n)` | `NodoAvl` | `NodoAvl n` | Realiza una rotación doble derecha en el nodo especificado. Retorna el nuevo nodo raíz después de la rotación. |

### ObtencionDatos

#### Descripción
La clase `ObtencionDatos` realiza la obtención y procesamiento de datos, utilizando un árbol balanceado (`ArbolBalanceado`) y almacenando los resultados en un archivo binario.

#### Métodos

| Método | Tipo de Dato que Retorna | Tipo de dato que recibe | Descripción |
|--------|-------------------------|-------------------------|-------------|
| `procesarDatos()` | `ArbolBalanceado` | - | Realiza el procesamiento de datos, lee un archivo CSV, crea un árbol balanceado, y almacena datos procesados en un archivo binario. Retorna el árbol balanceado resultante. |
| `consultar(int posicion)` | `Dato` | `int posicion` | Consulta y retorna un objeto `Dato` en la posición especificada en el archivo binario. |
| `tryParseInt(String value)` | `int` | `String value` | Intenta parsear un entero desde una cadena. Retorna 0 si la conversión no es posible. |
| `obtenerUltimoDigito(int numero)` | `int` | `int numero` | Obtiene el último dígito de un número. Retorna 7 si hay un error durante la obtención. |
| `obtenerUltimoCaracter(String dato, int pos)` | `char` | `String dato, int pos` | Obtiene el último carácter de una cadena en una posición especificada. Retorna 'x' si hay un error durante la obtención. |

### Main

#### Descripción
La clase `Main` representa la interfaz gráfica de usuario para la búsqueda de elementos en un árbol binario balanceado.
#### Campos
| Tipo | Campo | Descripción |
|------|-------|-------------|
| `ArbolBalanceado` | `arbol` | Representa el árbol binario balanceado utilizado para la búsqueda de elementos. |
#### Constructores
| Constructor | Descripción |
|-------------|-------------|
| `Main()` | Crea una nueva instancia de la interfaz gráfica para la búsqueda de elementos. |
#### Métodos
| Nombre | Tipo de Dato que Retorna | Tipo de dato que recibe | Descripción |
|--------|--------|-------------------------|-------------|
| `initComponents()` | `void` | - | Inicializa y configura los componentes de la interfaz gráfica. |
| `imprimirDato(JTextArea textArea, Dato d)` | `void` | `JTextArea textArea`, `Dato d` | Imprime la información de un dato en el área de texto especificada. |

## Casos de pruebas
- `AN087`
```
Información del Dato:
Nombre Municipio    : Asunción Nochixtlán 
Nombre Localidad    : Nuevo Yucahua       
Población Masculina : 0         
Población Femenina  : 0         
Latitud             : "17°28'00.418"" N"  
Longitud            : " 97°10'49.897"" W" 
```
- `SE533`
```
Información del Dato:
Nombre Municipio    : Santa Inés de Zaragoza
Nombre Localidad    : El Molino           
Población Masculina : 21        
Población Femenina  : 34        
Latitud             : "17°15'36.553"" N"  
Longitud            : " 97°10'12.123"" W" 
```
- `SC129`
```
Información del Dato:
Nombre Municipio    : Santiago Tlazoyaltepec
Nombre Localidad    : Cañada de Ceniza    
Población Masculina : 15        
Población Femenina  : 16        
Latitud             : "17°01'05.102"" N"  
Longitud            : " 96°57'47.129"" W" 
```

- `CE048`
```
Información del Dato:
Nombre Municipio    : Candelaria Loxicha  
Nombre Localidad    : El Encanto          
Población Masculina : 0         
Población Femenina  : 0         
Latitud             : "15°57'47.294"" N"  
Longitud            : " 96°31'14.318"" W" 
```

- `SL0xx`
```
Información del Dato:
Nombre Municipio    : San Juan Bautista Valle Nacional
Nombre Localidad    : Localidades de dos viviendas
Población Masculina : 13        
Población Femenina  : 17        
Latitud             :                     
Longitud            :                     
```

