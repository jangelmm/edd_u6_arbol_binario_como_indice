/*
 * Alumno: Jesús Ángel Martínez Mendoza | 22161152
 * Asignatura: Estructura de Datos
 * Docente: Dalia Silva Martínez
 * Grupo: 3SC | 13:00 - 14:00
 * Semestre: 3ro | AGO - DIC 2023
 */

public class ArbolBalanceado{
    private NodoAvl raiz;
    private int cont;
    public ArbolBalanceado(){
        raiz=null;
    }
    public NodoAvl buscar(int x){
        NodoAvl aux = raiz;
        while(aux!=null && (int)aux.getIdentifi()!=x){
            if((int)aux.getIdentifi()>x){
                aux=aux.getIzquierda();
            }else{
                aux=aux.getDerecha();
            }
        }
        return aux;
    }
    //insertar avl
    private NodoAvl insertarAVL(NodoAvl nuevo, NodoAvl subAr){
        NodoAvl nuevoPadre=subAr;
        if((int)nuevo.getIdentifi()<(int)subAr.getIdentifi()){
            if(subAr.getIzquierda()==null){
                subAr.setIzquierda(nuevo);
            }else{
                subAr.setIzquierda(insertarAVL(nuevo, subAr.getIzquierda()));
                if((obtenerFe(subAr.getIzquierda())-obtenerFe(subAr.getDerecha())==2)){
                    if((int)nuevo.getIdentifi()<(int)subAr.getIzquierda().getIdentifi()){
                        nuevoPadre=rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                    }
                }
            }
        }else if((int)nuevo.getIdentifi()>(int)subAr.getIdentifi()){
            if(subAr.getDerecha()==null){
                subAr.setDerecha(nuevo);
            }else{
                subAr.setDerecha(insertarAVL(nuevo, subAr.getDerecha()));
                if((obtenerFe(subAr.getDerecha())-obtenerFe(subAr.getIzquierda())==2)){
                    if((int)nuevo.getIdentifi()>(int)subAr.getDerecha().getIdentifi()){
                        nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            //System.out.println("repetido");
            return null;
        }
    
      //actualizar altura
        if((subAr.getIzquierda()==null)&&(subAr.getDerecha()!=null)){
            subAr.setFe(subAr.getDerecha().getFe()+1);
        }else if((subAr.getDerecha()==null)&&(subAr.getIzquierda()!=null)){
            subAr.setFe(subAr.getIzquierda().getFe()+1);
        }else{
            subAr.setFe(Math.max(obtenerFe(subAr.getIzquierda()), obtenerFe(subAr.getDerecha()))+1);
        }
        return nuevoPadre;
    }
    //insertar normal
    public boolean insertar(int i, int j){
       NodoAvl nuevo = new NodoAvl(i, j);
       if(raiz==null){
           raiz=nuevo;
           return true;
       }
       NodoAvl aux = insertarAVL(nuevo, raiz);
       if(aux==null) return false;
       raiz = aux;
       return true;
    }
    
    public void inOrden(){
        ayudaInOrden(raiz);
        System.out.println();
    }
    private void ayudaInOrden(NodoAvl aux){
        if(aux!=null){
            ayudaInOrden(aux.getIzquierda());
            System.out.print("  "+aux.getIdentifi());
            ayudaInOrden(aux.getDerecha());
        }
    }
    public void posOrden(){
        ayudaPosOrden(raiz);
    }
    private void ayudaPosOrden(NodoAvl aux){
        if(aux!=null){
            ayudaPosOrden(aux.getIzquierda());
            ayudaPosOrden(aux.getDerecha());
            System.out.print("  "+aux.getIdentifi());
        }
    }
    public void preOrden(){
        ayudaPreOrden(raiz);
    }
    private void ayudaPreOrden(NodoAvl aux){
        if(aux!=null){
            System.out.print("  "+aux.getIdentifi());
            ayudaPreOrden(aux.getIzquierda());
            ayudaPreOrden(aux.getDerecha());
        }
    }
    public int size(){
        return ayudaSize(raiz);
    }
    private int ayudaSize(NodoAvl aux){
        if(aux!=null)return (1 + ayudaSize(aux.getIzquierda()) + ayudaSize(aux.getDerecha()));
        return 0;
    }
    public boolean eliminar(int o, int modo){
        NodoAvl aux=raiz, ant=null;
        while(aux!=null && (int)aux.getIdentifi()!=o){
            ant=aux;
            if((int)aux.getIdentifi()>o){
                aux=aux.getIzquierda();
            }else{
                aux=aux.getDerecha();
            }
        }
        if(aux==null)return false;
        if(aux==raiz)raiz = borrarNodo(aux, modo);
        else{
            if(ant.getIzquierda()==aux) ant.setIzquierda(borrarNodo(aux, modo));
            else ant.setDerecha(borrarNodo(aux, modo));
        }
        
        if(ant==null)return true;
        if((ant.getIzquierda()==null)&&(ant.getDerecha()!=null)){
            ant.setFe(ant.getDerecha().getFe()+1);
        }else if((raiz.getDerecha()==null)&&(ant.getIzquierda()!=null)){
            ant.setFe(ant.getIzquierda().getFe()+1);
        }else{
            ant.setFe(Math.max(obtenerFe(ant.getIzquierda()), obtenerFe(ant.getDerecha()))+1);
        }
        return true;
    }
    private NodoAvl borrarNodo(NodoAvl n, int modo){
        if(n.getIzquierda()==null){
            return n.getDerecha();
        }else{
            if(n.getDerecha()==null){
                return n.getIzquierda();
            }else{
                NodoAvl aux = n.getDerecha(), ant = null;
                while(aux.getIzquierda()!=null){
                    ant=aux;
                    aux=aux.getIzquierda();
                }
                n.setIdentifi(aux.getIdentifi());
                n.setPosicion(aux.getPosicion());
                if(modo==1)cont++;
                if(ant!=null){
                    ant.setIzquierda(aux.getDerecha());
                    cont++;
                }else{
                    n.setDerecha(aux.getDerecha());
                }
                return n;
            }
        }
    }
    public int getRaiz(){
        return (int)raiz.getIdentifi();
    }
    public int salvarInOrden(int i){
        int x=1;
        if(buscar(x)==null) return 0;
        do{
            salvarInOrden(raiz, x, i);
            x=0;
        }while(this.size()>1);
        int salvado = (int)raiz.getIdentifi();
        raiz = null;
        return salvado;
    }
    public int salvarPosOrden(int i){
        int x=1;
        if(buscar(x)==null) return 0;
        do{
            salvarPosOrden(raiz, x, i);
            x=0;
        }while(this.size()>1);
        int salvado = (int)raiz.getIdentifi();
        raiz = null;
        return salvado;
    }
    public int salvarPreOrden(int i){
        int x=1;
        if(buscar(x)==null) return 0;
        do{
            salvarPreOrden(raiz, x, i);
            x=0;
        }while(this.size()>1);
        int salvado = (int)raiz.getIdentifi();
        raiz = null;
        return salvado;
    }
    private int salvarInOrden(NodoAvl aux, int x, int i){
        if(aux!=null){
            x=salvarInOrden(aux.getIzquierda(),x ,i);
            if((int)aux.getIdentifi()==x){
                x=0;
                cont=1;
            }else if(cont>=(i-1) && x==0){
                cont=0;
                eliminar((int)aux.getIdentifi() ,1);
            }else{
                cont++;
            }
            x=salvarInOrden(aux.getDerecha(),x ,i);
        }
        return x;
    }
    private int salvarPosOrden(NodoAvl aux, int x, int i){
        if(aux!=null){
            x=salvarPosOrden(aux.getIzquierda(), x, i);
            x=salvarPosOrden(aux.getDerecha(), x, i);
            if((int)aux.getIdentifi()==x){
                x=0;
                cont=1;
            }else if(cont>=(i-1) && x==0){
                cont=0;
                eliminar((int)aux.getIdentifi(), 2);
            }else{
                cont++;
            }
        }
        return x;
    }
    private int salvarPreOrden(NodoAvl aux, int x, int i){
        if(aux!=null){
            if((int)aux.getIdentifi()==x){
                x=0;
                cont=1;
            }else if(cont>=(i-1) && x==0){
                cont=0;
                eliminar((int)aux.getIdentifi(), 1);
            }else{
                cont++;
            }
            x=salvarPreOrden(aux.getIzquierda(),x ,i);
            x=salvarPreOrden(aux.getDerecha(),x ,i);
        }
        return x;
    }
    //METODOS DEL ARBOL BINARIO BALANCEADO
    public int obtenerFe(NodoAvl aux){
        if(aux==null) return -1;
        return aux.getFe();
    }
    //Rotacion simple izquierda
    //Rotacion simple izquierda
    public NodoAvl rotacionIzquierda(NodoAvl n){
    if (n != null && n.getIzquierda() != null) {
        NodoAvl aux = n.getIzquierda();
        if (aux.getDerecha() != null) { // Verificar si aux.getDerecha() es nulo
            n.setIzquierda(aux.getDerecha());
            aux.setDerecha(n);
            n.setFe(Math.max(obtenerFe(n.getIzquierda()), obtenerFe(n.getDerecha())) + 1);
            aux.setFe(Math.max(obtenerFe(aux.getIzquierda()), obtenerFe(aux.getDerecha())) + 1);
            return aux;
        }
    }
    // Si n, n.getIzquierda() o aux.getDerecha() es nulo, simplemente retornar n
    return n;
    }

    //Rotacion simple derecha
    public NodoAvl rotacionDerecha(NodoAvl n) {
    // Verificar si n o n.getIzquierda() es nulo antes de realizar la rotación
    if (n != null && n.getIzquierda() != null) {
        NodoAvl aux = n.getIzquierda();
        n.setIzquierda(aux.getDerecha());
        aux.setDerecha(n);
        n.setFe(Math.max(obtenerFe(n.getIzquierda()), obtenerFe(n.getDerecha())) + 1);
        aux.setFe(Math.max(obtenerFe(aux.getIzquierda()), obtenerFe(aux.getDerecha())) + 1);
        return aux;
    }
    // Si n o n.getIzquierda() es nulo, simplemente retornar n
    return n;
    }

    //Rotacion doble izquierda
    public NodoAvl rotacionDobleIzquierda(NodoAvl n){
        n.setIzquierda(rotacionDerecha(n.getIzquierda()));
        NodoAvl aux = rotacionIzquierda(n);
        return aux;
    }
    //Rotacion doble derecha
    public NodoAvl rotacionDobleDerecha(NodoAvl n){
        n.setDerecha(rotacionIzquierda(n.getDerecha()));
        NodoAvl aux = rotacionDerecha(n);
        return aux;
    }
}