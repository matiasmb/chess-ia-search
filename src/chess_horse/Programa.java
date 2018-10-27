package  chess_horse;
import java.util.*;

public class Programa {
static posicionesposiblesxpiezas posiciones[][]=new posicionesposiblesxpiezas[8][8]; //el primer subindice es el de los renglones!
 /* ak tengo que cargar las posiciones de los caballos que tengo que matar*/static int[]piezaspormatar=new int[1];   /**
     * @param args the command line arguments
     */
 static ArrayList <Integer> nivel= new ArrayList ();
 public static ArrayList <Integer> resultado=new  ArrayList();
 public static ArrayList <Integer> piezasamatar = new  ArrayList();

 static void  resetear(){
resultado.clear();
piezasamatar.clear();
nivel.clear(); abiertos.clear();resultadoff.clear(); anterior=234; total=0; corte=0;
 control=0;
 }



 static boolean matartodos(int p){
boolean t=true;
    for (int y=0;y<piezaspormatar.length;y++){  //cuando mata hay q poner un high value
   if (piezaspormatar[y]<64)
       t=false;
    if(piezaspormatar[y]==p) piezaspormatar[y]=999;

    }
return (t);
}
static void  cargarpiezasamatar(ArrayList p){
piezasamatar.clear();
piezasamatar=p;

};
static ArrayList <Integer> lasquequedanpormatar(){
return (piezasamatar);
}

//  *********************************************   A*  *************************************
static int heuristica (int h, ArrayList <Integer> pormatar){  
// int []a=posiciones[h-(h/8)*8][h/8].posibilidades();  
 int area,x,y=0;

 //for (int yy=0;yy<a.length;yy++)
 
   ArrayList <Integer> ww= new ArrayList ();
   // if (a[yy]<65){
    for (int p=0; p<pormatar.size();p++){
   x=Math.abs((pormatar.get(p)-((pormatar.get(p))/8)*8)-(h-(h/8)*8));  //obtengo la diferencia entre las coro
   y= Math.abs(((pormatar.get(p))/8)-(h/8));

 
  area=Programa.asignarvalor(x+1,y+1,pormatar);
  
  //if (pormatar.contains(h)) {area++;}    //esta es la ultima parte de la heuristica
  ww.add(area);

   }

   Collections.sort(ww);
 int p=ww.get(0);   //elegimos el valor mas pequeño de heuristica para ESA posicion posible,que me la pasan como parametro

 return (p);

}


static ArrayList <ArrayList <Integer>> abiertos=new ArrayList();  //ver pero creo q esta bien

static ArrayList <Integer> obtenermenorf(){    //devuelve nodo donde esta el menor valor de la funcion euristica y le agrega como ultimo elemento la posicion de ese nodo en el arraylist abiertos
if (abiertos.size()>1)
    Programa.eliminarduplicados();

System.out.println(abiertos.size());
int costototal=((abiertos.get(0)).get(0))+((abiertos.get(0)).get(1));

int pos=0; int costototalj=0;
for (int j=0;j<abiertos.size();j++){
     costototalj=abiertos.get(j).get(0) + abiertos.get(j).get(1);
     if(costototal>costototalj)
     {costototal=costototalj;
      pos =j;}
     }
ArrayList <Integer> p=abiertos.get(pos);
p.add(pos);
return(p);
}

static ArrayList <Integer> resultadoff=new ArrayList();

static boolean matartodos(ArrayList<Integer> p){
boolean f=true;
ArrayList <Integer> h= new ArrayList();
for (int yy=2;yy<p.size()-1;yy++){
h.add(p.get(yy));  //ak lo que hago es deshacerme de las dos primeras posiciones de p, y  de la ultima, ya no hacen a las posiciones recorridas
}
//ahora tengo q recorrer las cada una de las piezas a matar y preguntar si se encuentra en h, si todas estan es porque en la secuencia de movimientos mate todas!
for (int j=0;j<piezasamatar.size();j++){
  if(!h.contains(piezasamatar.get(j)))
    f=false;
}


   

if (f){ 
     resultadoff=h;
 //for (int hh=0;hh<h.size();hh++){
 // resultadoff.add(h.get(hh));
  //}
}

return(f);
}
static int anterior=234;
static void generarnodoseinsertar (ArrayList <Integer> t){
//Programa.eliminarduplicados();
    int s= t.get(t.size()-1);   //posicion del nodo t en abiertos
   int g=t.get(t.size()-2);  //ultima posicion de la secuencia de movimientos del nodo t

 
   int c[]=new int[8]; 
   c=(posiciones[(g/8)][(g-(8*(g/8)))]).posibilidades();
      //veeerrr   g-(g/8)*8   g/8

   /*ArrayList <Integer> o=new ArrayList();
   for (int y=2;y<t.size()-1;y++){              //ak yo copio en "o" la secuencia de movimientos hasta la posicion actual
   o.add(t.get(y));
   }


   ArrayList <Integer> p= new ArrayList ();
   for (int y=0;y<c.length;y++){
   if (!o.contains(c[y])) p.add(c[y]);
    }
  //p (arraylist) ahora si tiene las posiciones siguientes validas como para no hacer ciclos, ahora hay q pasar a un array todo
   int []pp=new int[p.size()];
   for (int h=0;h<pp.length;h++){
   pp[h]=p.get(h);
   }

*/
  ArrayList <Integer> lasqquedanpormatar=new ArrayList();
   ArrayList <Integer> tt=new ArrayList();
   for (int j=2;j<t.size()-2;j++){
     tt.add(t.get(j));

   }  //en tt esta la cadena de movimientos actual
 for (int kk=0; kk<piezasamatar.size();kk++){
 if (!tt.contains(piezasamatar.get(kk))) lasqquedanpormatar.add(piezasamatar.get(kk));
 
 }


   //esto es cualquier cosa!!
   /*for (int w=2;w<t.size()-1;w++){
   if (!piezasamatar.contains(t.get(w)) & !lasqquedanpormatar.contains(t.get(w)))
      lasqquedanpormatar.add(t.get(w));
  
   }
*/

   for (int j=0; j <c.length;j++){   //itero por todas las posiciones posibles


       if (c[j]<65){
       ArrayList <Integer> h=new ArrayList();
       int v;
       for (int pppp=0; pppp<t.size(); pppp++){
          v=t.get(pppp);
           h.add(v);
       }


       h.remove(h.size()-1);  //borramos el ultimo elemento ya que era el de la posicion en abiertos
         //if (h.size()>1 & h.contains(c[j]) & c[j]==h.get(h.size()-2)){
        h.add(c[j]);
       int k=h.get(0);
       k++;
       h.set(0,k);
      h.set(1,Programa.heuristica2(c[j],lasqquedanpormatar));
     //  h.set(1,Programa.heuristica(c[j],lasqquedanpormatar));
      
       
    
       
      
     
       abiertos.add(s,h);
       for(int gg=0;gg<abiertos.get(s).size();gg++) System.out.println(abiertos.get(s).get(gg)+"aaaa");
       if(j==0) abiertos.remove(s+1);
       s++; 
      
       }
        
     //  }

   }
    
}
static int total;


static int heuristica2 (int p,ArrayList <Integer> lasqquedanpormatar){  //recibo la posicion siguiente
 // if (lasqquedanpormatar.contains(p))
   //  if (lasqquedanpormatar.contains(p)){  return (1000-(((total-lasqquedanpormatar.size()))*12));}else
     return (1000-(total-(lasqquedanpormatar.size()))*6);
    //  return (1000-(((total-lasqquedanpormatar.size()))*10));
         //else
         // return (10000-(total-(lasqquedanpormatar.size())));
}




static ArrayList <Integer> aestrella(int posnegroo){
   total=piezasamatar.size();
    ArrayList <Integer> j= new ArrayList();
   j.add(0);
   j.add(Programa.heuristica2(posnegroo,piezasamatar));
   j.add(posnegroo);

  boolean v=true;
   abiertos.add(j);
 

   while(v){
   ArrayList <Integer> u=Programa.obtenermenorf();   //la ultima posicion de u es la posicion dentro de abiertos donde esta el menor
  
   if (!Programa.matartodos(u)){
    Programa.generarnodoseinsertar(u);}
   else
   { v=false; 
      for (int y=0;y<abiertos.size();y++){
        
          for (int c=0;c<abiertos.get(y).size();c++){ System.out.println(abiertos.get(y).get(c));}
      }
   }
  //u.clear();
}

for (int l=0;l<resultadoff.size();l++) System.out.println(resultadoff.get(l));
   return (resultadoff);
}

static void eliminarduplicados()
{
ArrayList <Integer> posicionesaborrar=new ArrayList() ; int ultimodeu;

for (int u=0; u<abiertos.size();u++){
ultimodeu=abiertos.get(u).get(((abiertos.get(u)).size())-1); //ultimo elemento de la secuencia de movimientos del nodo u
    for (int z=0; z<abiertos.size();z++){
if ((ultimodeu==abiertos.get(z).get(abiertos.get(z).size()-1))&((abiertos.get(z).get(0)+abiertos.get(z).get(1))>(abiertos.get(u).get(0)+abiertos.get(u).get(1))))
{if (!posicionesaborrar.contains(z))
  {posicionesaborrar.add(z);}}
}

}

if (posicionesaborrar.isEmpty()) System.out.println("no hay nada para borrar");
int h; Collections.sort(posicionesaborrar);
while (!posicionesaborrar.isEmpty()){//ak va el codigo para eliminar posiciones repetidas de posiciones a borrar!!
h=posicionesaborrar.get(0);
    abiertos.remove(h);
    posicionesaborrar.remove(0);
    if (!posicionesaborrar.isEmpty()){
    for (int i=0;i<posicionesaborrar.size();i++) {   //actualizo todos los indices cuando borro un nodoo
        int k =posicionesaborrar.get(i); k--;
        posicionesaborrar.set(i,k);
    }}

}






}





static int asignarvalor(int x, int y,ArrayList <Integer> lasqquedanpormatar){
int valor=0;
ArrayList <Integer> areados= new ArrayList();areados.add(3);  areados.add(4);  areados.add(5);  areados.add(8);  areados.add(15);  areados.add(16);
 ArrayList <Integer> areatres= new ArrayList(); areatres.add(2);  areatres.add(4);      areatres.add(10);    areatres.add(12);  areatres.add(6); areatres.add(18);   areatres.add(30);   areatres.add(14);   areatres.add(28);   areatres.add(20);
  ArrayList <Integer> areacuatro= new ArrayList();  areacuatro.add(9); areacuatro.add(12);   areacuatro.add(7);   areacuatro.add(27);   areacuatro.add(45);   areacuatro.add(21);   areacuatro.add(35);   areacuatro.add(49);   areacuatro.add(16);   areacuatro.add(32);   areacuatro.add(48);   areacuatro.add(24);
  ArrayList <Integer> areacinco= new ArrayList();     areacinco.add(8); areacinco.add(24); areacinco.add(40); areacinco.add(42); areacinco.add(56); areacinco.add(36); areacinco.add(54); areacinco.add(72);




//recibe como parametro el valor de un area y devuelve el valor de la euristica + la suma con la expresion...
valor=6;
  if ((x*y)==4)
  { if (x==y) valor=2; else valor=3;}
  
    if ((x*y)==8) { if ((x==1)| (y==1)) valor=5; else valor=2; }
    
        if (x*y==12){if ((x==3)| (y==3)) valor=3; else valor=4;}
        
            if (x*y==16){if (x==y) valor=2; else if ((x==8)|(y==8)) valor=4;}
            
                if (x*y==24) {if ((x==6)|(y==6)) valor=4; else valor=5;}
                
                    if (x*y==1) valor=0;
                if (x*y==6) {if (x==1 | y==1 ) valor= 3; else valor=1;}
                     if (areados.contains(x*y)) valor=2;
                     if (areatres.contains (x*y)) valor=3;
                    if (areacuatro.contains (x*y))valor=4;
                    if (areacinco.contains(x*y)) valor=5;
                   


return (valor+((lasqquedanpormatar.size()))*6);
/*if (valor==0){
return (valor+((lasqquedanpormatar.size()))*6);}  //MODIFICARRR ESTO SI OSI ISSISSS
else return (valor+(lasqquedanpormatar.size())*6);*/



}
//*******************************************************************   A*  **************************+

static boolean mataralguno(int f[]) {
//en este metodo puedo realizar modificaciones y hacer q mate todo de una!, pero esto puedo llenar la memoria!
//boolean p=false;
  boolean p=true;

  for (int pp=0;pp< piezasamatar.size();pp++){
   boolean z=false;
 ArrayList <Integer> posicionesaborrar= new ArrayList();
   for (int u=0;u<f.length;u++){
      if(f[u]== piezasamatar.get(pp) & !posicionesaborrar.contains(pp) ){z=true; posicionesaborrar.add(pp);} //saco esa pieza de las piezas a matar}}
 }if (z==false) p=false;
   //si p=false no mate todas todavia

}
//ahora tenemos que eliminar las posciones que estan en posicionesaremover de piezasamatar si es q mate todas!!




/*for (int h=0;h<f.length;h++){


    if (piezasamatar.contains(f[h])) {p=true;for (int u=0;u<piezasamatar.size();u++){if (piezasamatar.get(u)==f[h])piezasamatar.remove(u);}}  //supuestamente ak saque la pieza que mato


                            } 
*/
if (p){ //solo p ak
 ArrayList <Integer> j=new ArrayList  ();
for (int h=0;h<f.length;h++){
resultado.add(f[h]);
}
piezasamatar.clear();
 return (true);
}
     //cargo la secuencia de movimientos que mata esa pieza en la variable global resultad
return (p);

}

static boolean evitarciclos(int k[], int h) {   //con esto evitamos crear un nodo donde haye ciclos, osea donde haye dos nodos repetidos
boolean s=false;
for (int u=0;u < k.length;u++){
 if(k[u]==h)
     s=true;
}
return(s);

}
static ArrayList <Integer> amplitud (int niv){

int posicioninicial=niv;
ArrayList <Integer> resultadofinal=new ArrayList();
resultadofinal.add(2);  //por poner noma!, es para que no me repita las piezas que mata en la secuencia resultado final
ArrayList <Integer> aux=new ArrayList();
while (!(piezasamatar.isEmpty())){
resultadofinal.remove(resultadofinal.size()-1);
    nivel.add(posicioninicial);  //posicion del caballo negro

aux=Programa.buscaramplitud(1);  //el 1 no se toca!!
nivel.clear();
for (int h=0;h<aux.size();h++){
   resultadofinal.add(aux.get(h));}
posicioninicial=resultadofinal.get((resultadofinal.size())-1);
aux.clear();
}
return (resultadofinal);
}

 static ArrayList <Integer> buscaramplitud (int niv) {
 if (resultado.isEmpty()){
   int arraydenivel[]=new int[nivel.size()];
   for (int r=0;r<nivel.size();r++){          //cargo el arreglo de nivel
   arraydenivel[r]=nivel.get(r);
   }
 

     for (int y=0; y<((arraydenivel.length)/niv);y++){
    int c[]=new int[niv];
    System.arraycopy(arraydenivel, y*niv, c,0, niv);
         boolean t=Programa.mataralguno(c);
         if (t==true)
             return(resultado);


}
//hasta aca nos fijamos si matamos algo en el nivel correspondiente, ahora debemos generar el siguiente nivel
ArrayList <Integer> h= new ArrayList();
for (int j=0;(j<(arraydenivel.length)/niv);j++){
int []p=new int [niv];            //p contiene todos los elementos de un nodo correspondiente
    System.arraycopy(arraydenivel, j*niv, p, 0, niv); //ahora si p contiene todos los elementos de un nodo correspondiente jej

    int pos[]=new int[8];
   int g=(p[p.length-1]/8);
   int y=((p[p.length-1])-(8*(p[p.length-1]/8)));   //calculo la posicion en la matriz del elemento ultimo, para asi poder anexar con cada uno de sus sucesores

   pos=(posiciones[g][y]).posibilidades();   //simplemente busco las posiciones posibles en formato array del ultimo elemento del array p
   for (int k=0;k<pos.length;k++){
       if (pos[k]<65 & true){   // donde dice true, puedo  evitar ciclos poniendo  !(Main.evitarciclos(p,pos[k])), esto va a ser q se evite pasar dos veces por el mismo casillero aunque para casos donde se tengan q matar muchas piezas, esto nos complica
       for (int i=0;i<p.length;i++){
       h.add(p[i]);}
       h.add(pos[k]);
       }

   }
}
nivel.clear();
nivel=h;
ArrayList <Integer> w= new ArrayList ();
int b=niv;
Programa.buscaramplitud(b +1);

 }
return(resultado);}




//este ya fue ya
 static int [] buscar (int posicion, int nivel,int posicionanterior){
int p=nivel +1;
    if (Programa.matar1pieza(posicion)==true){
     p=0;}
    if (Programa.matartodos(posicion)==true){
     int c[]=new int[1];
     c[0]=posicion;
     return (c);}

    if(nivel>6) {          //cuando estoy dando muchas vueltas sin matar
    int c[]=new int[1];
    c[0]=999;
    return (c);}
{


   int pposibles[]=new int[8];
   pposibles= (posiciones[(posicion/8)][(posicion-(8*(posicion/8)))]).posibilidades();
   for (int i=0;i<8;i++){
       if (pposibles[i]<65 & pposibles[i]!=posicionanterior){  //cuidado con el valor hv como posicion posible!
       int b[]=Programa.buscar(pposibles[i],p,posicion);

   if (b[b.length-1]<65){   // ultimo elemento de la matriz, ver como hacer funcionar size()!!!
   int x[]=new int[1+b.length];
   x[0]=posicion;
   for (int h=1; h<b.length;h++){
    x[h]=b[h-1];

   }
    //ultima posicion del arreglo
   return(x);
   }}
   }



    }
int t[]=new int[1];
   t[0]=999;
   return(t);
}
static int control=0;   //variable global
static int corte=0;
static  void cargacorte(int u){
corte=u;
}


static ArrayList <Integer> profundidad (int pos,int nivel,int anterior){
 if(nivel==corte+1)
     {
      ArrayList <Integer> p= new ArrayList <Integer>();
      p.add(999);
      return(p);
     }
 int antes=piezasamatar.size();
 if (Programa.matartodoss(pos)){
 ArrayList <Integer> p= new ArrayList <Integer>();
 p.add(pos);
 return(p);
}
 if(antes!=piezasamatar.size())     //controlo si mate solo 1, pongo nivel a 0
     nivel=0;
 else
 nivel++;
 int []pp=new int[8];
 pp= (posiciones[(pos/8)][(pos-(8*(pos/8)))]).posibilidades();
 for (int i=0;i<pp.length;i++){
 if(pp[i]<65 && pp[i]!=anterior ){
     ArrayList <Integer> j=new ArrayList <Integer>();
     j=Programa.profundidad(pp[i],nivel,pos);
     if (j.get(0)<65)   //primera posicion
 {
     j.add(0,pos);  //ver

     return (j);
 }
 }

 }
 ArrayList <Integer> p=new ArrayList<Integer> ();
 p.add(999);
 return(p);
 }

 static boolean matartodoss(int c){
 if (piezasamatar.contains(c)){
     for (int y=0;y<piezasamatar.size();y++){
     if (piezasamatar.get(y)==c) piezasamatar.remove(y);    //eliminamos la pieza que matamos
     }

 }
 return(piezasamatar.isEmpty());
 }



public static boolean matar1pieza(int p){
boolean t=false;
  for (int y=0;y<piezaspormatar.length;y++){
  if (piezaspormatar[y]==p){
  piezaspormatar[y]=999; //le mando un high value ak si mate una pieza, ya que 0 tambien es una posicion!
  t=true;}
  }
  return (t);



  }


public static void main() {
 //ahi cree el arreglo bidimensional que va a contener todos los posibles movimientos del caballo de acuerdo al lugar donde este
   posicionesposiblesxpiezas t00=new posicionesposiblesxpiezas(17,10,9999,9999,9999,9999,999,999);
   posiciones[0][0]=t00;      //aca empiezo a cargar una por una las posiciones posibles de acuerdo a la ubicaciones del caballo..son 64 cargas!!
   posicionesposiblesxpiezas t01=new posicionesposiblesxpiezas(16,18,11,999,999,9999,9999,999);
   posiciones [0][1]=t01;
posicionesposiblesxpiezas t02=new posicionesposiblesxpiezas(8,17,19,12,999,999,999,9999);

   posiciones [0][2]=t02;
    posicionesposiblesxpiezas t03=new posicionesposiblesxpiezas(18,20,9,13,999,999,9999,9999);

   posiciones [0][3]=t03;    // TODO code application logic here
   posicionesposiblesxpiezas t04=new posicionesposiblesxpiezas(19,21,10,14,999,9999,999,999);

   posiciones [0][4]=t04;
   posicionesposiblesxpiezas t05=new posicionesposiblesxpiezas(20,22,11,15,999,999,999,999);


   posiciones [0][5]=t05;
   posicionesposiblesxpiezas t06=new posicionesposiblesxpiezas(21,23,12,999,999,9999,9999,999);

   posiciones [0][6]=t06;
   posicionesposiblesxpiezas t07=new posicionesposiblesxpiezas(13,22,999,999,999,999,999,999);
   posiciones [0][7]=t07;
    //termine de cargar la primer fila.
   posicionesposiblesxpiezas t08=new posicionesposiblesxpiezas(25,18,2,999,999,999,999,999);
   posiciones [1][0]=t08;
    posicionesposiblesxpiezas t09=new posicionesposiblesxpiezas(24,26,19,3,999,999,999,999);
   posiciones [1][1]=t09;
    posicionesposiblesxpiezas t10=new posicionesposiblesxpiezas(16,25,27,20,4,0,999,999);
   posiciones [1][2]=t10;
   posicionesposiblesxpiezas t11=new posicionesposiblesxpiezas(1,17,26,28,21,5,999,999);
   posiciones [1][3]=t11;
    posicionesposiblesxpiezas t12=new posicionesposiblesxpiezas(2,18,27,29,22,6,999,999);
   posiciones [1][4]=t12;
    posicionesposiblesxpiezas t13=new posicionesposiblesxpiezas(3,19,28,30,23,7,999,999);
   posiciones [1][5]=t13;
    posicionesposiblesxpiezas t14=new posicionesposiblesxpiezas(4,20,29,31,999,999,999,999);
   posiciones [1][6]=t14;
    posicionesposiblesxpiezas t15=new posicionesposiblesxpiezas(5,21,30,999,999,999,999,999);
   posiciones [1][7]=t15;
    //termine de cargar la 2da fila


  posicionesposiblesxpiezas t16=new posicionesposiblesxpiezas(1,10,26,33,999,999,999,999);
   posiciones [2][0]=t16;
    posicionesposiblesxpiezas t17=new posicionesposiblesxpiezas(0,2,11,27,34,32,999,999);
   posiciones [2][1]=t17;
    posicionesposiblesxpiezas t18=new posicionesposiblesxpiezas(1,3,12,28,35,33,24,8);
   posiciones [2][2]=t18;
   posicionesposiblesxpiezas t19=new posicionesposiblesxpiezas(2,4,13,29,36,34,25,9);
   posiciones [2][3]=t19;
    posicionesposiblesxpiezas t20=new posicionesposiblesxpiezas(3,5,14,30,37,35,26,10);
   posiciones [2][4]=t20;
    posicionesposiblesxpiezas t21=new posicionesposiblesxpiezas(4,6,15,31,38,36,27,11);
   posiciones [2][5]=t21;
    posicionesposiblesxpiezas t22=new posicionesposiblesxpiezas(5,7,37,39,28,12,999,999);
   posiciones [2][6]=t22;
    posicionesposiblesxpiezas t23=new posicionesposiblesxpiezas(6,13,29,38,999,999,999,999);
   posiciones [2][7]=t23;
   //termine de cargar la 3era fila
   posicionesposiblesxpiezas t24=new posicionesposiblesxpiezas(9,18,34,41,999,999,999,999);
   posiciones [3][0]=t24;
    posicionesposiblesxpiezas t25=new posicionesposiblesxpiezas(8,10,19,35,40,42,999,999);
   posiciones [3][1]=t25;
    posicionesposiblesxpiezas t26=new posicionesposiblesxpiezas(9,11,20,36,43,41,32,16);
   posiciones [3][2]=t26;
   posicionesposiblesxpiezas t27=new posicionesposiblesxpiezas(10,12,21,37,44,42,33,17);
   posiciones [3][3]=t27;
    posicionesposiblesxpiezas t28=new posicionesposiblesxpiezas(11,13,22,38,45,43,34,18);
   posiciones [3][4]=t28;
    posicionesposiblesxpiezas t29=new posicionesposiblesxpiezas(12,14,23,39,46,44,19,35);
   posiciones [3][5]=t29;
    posicionesposiblesxpiezas t30=new posicionesposiblesxpiezas(13,15,45,47,36,20,999,999);
   posiciones [3][6]=t30;
    posicionesposiblesxpiezas t31=new posicionesposiblesxpiezas(14,21,37,46,999,999,999,999);
   posiciones [3][7]=t31;
   //cargada la 4ta fila
   posicionesposiblesxpiezas t32=new posicionesposiblesxpiezas(17,26,42,49,999,999,999,999);
   posiciones [4][0]=t32;
    posicionesposiblesxpiezas t33=new posicionesposiblesxpiezas(16,18,27,43,50,48,999,999);
   posiciones [4][1]=t33;
    posicionesposiblesxpiezas t34=new posicionesposiblesxpiezas(17,19,28,44,51,49,40,24);
   posiciones [4][2]=t34;
   posicionesposiblesxpiezas t35=new posicionesposiblesxpiezas(18,20,29,45,52,50,41,25);
   posiciones [4][3]=t35;
    posicionesposiblesxpiezas t36=new posicionesposiblesxpiezas(19,21,30,46,53,51,42,26);
   posiciones [4][4]=t36;
    posicionesposiblesxpiezas t37=new posicionesposiblesxpiezas(20,22,31,47,54,52,43,27);
   posiciones [4][5]=t37;
    posicionesposiblesxpiezas t38=new posicionesposiblesxpiezas(21,23,28,44,53,55,999,999);
   posiciones [4][6]=t38;
    posicionesposiblesxpiezas t39=new posicionesposiblesxpiezas(22,29,45,54,999,999,999,999);
   posiciones [4][7]=t39;
   //fila 5 cargada
   posicionesposiblesxpiezas t40=new posicionesposiblesxpiezas(25,34,50,57,999,999,999,999);
   posiciones [5][0]=t40;
    posicionesposiblesxpiezas t41=new posicionesposiblesxpiezas(24,26,35,51,58,56,999,999);
   posiciones [5][1]=t41;
    posicionesposiblesxpiezas t42=new posicionesposiblesxpiezas(25,27,36,52,59,57,48,32);
   posiciones [5][2]=t42;
   posicionesposiblesxpiezas t43=new posicionesposiblesxpiezas(26,28,37,53,60,58,49,33);
   posiciones [5][3]=t43;
    posicionesposiblesxpiezas t44=new posicionesposiblesxpiezas(27,29,38,54,61,59,50,34);
   posiciones [5][4]=t44;
    posicionesposiblesxpiezas t45=new posicionesposiblesxpiezas(28,30,39,55,62,60,51,35);
   posiciones [5][5]=t45;
    posicionesposiblesxpiezas t46=new posicionesposiblesxpiezas(29,31,36,52,61,63,999,999);
   posiciones [5][6]=t46;
    posicionesposiblesxpiezas t47=new posicionesposiblesxpiezas(30,37,53,62,999,999,999,999);
   posiciones [5][7]=t47;
   //terminada fila 6
   posicionesposiblesxpiezas t48=new posicionesposiblesxpiezas(33,42,58,999,999,999,999,999);
   posiciones [6][0]=t48;
    posicionesposiblesxpiezas t49=new posicionesposiblesxpiezas(32,34,43,59,999,999,999,999);
   posiciones [6][1]=t49;
    posicionesposiblesxpiezas t50=new posicionesposiblesxpiezas(33,35,44,60,40,56,999,999);
   posiciones [6][2]=t50;
   posicionesposiblesxpiezas t51=new posicionesposiblesxpiezas(34,36,45,61,57,41,999,999);
   posiciones [6][3]=t51;
    posicionesposiblesxpiezas t52=new posicionesposiblesxpiezas(35,37,46,62,58,42,999,999);
   posiciones [6][4]=t52;
    posicionesposiblesxpiezas t53=new posicionesposiblesxpiezas(36,38,47,63,59,43,999,999);
   posiciones [6][5]=t53;
    posicionesposiblesxpiezas t54=new posicionesposiblesxpiezas(37,39,44,60,999,999,999,999);
   posiciones [6][6]=t54;
    posicionesposiblesxpiezas t55=new posicionesposiblesxpiezas(38,45,61,999,999,999,999,999);
   posiciones [6][7]=t55;
   //cargada fila 7
   posicionesposiblesxpiezas t56=new posicionesposiblesxpiezas(41,50,999,999,999,999,999,999);
   posiciones [7][0]=t56;
    posicionesposiblesxpiezas t57=new posicionesposiblesxpiezas(40,42,51,999,999,999,999,999);
   posiciones [7][1]=t57;
    posicionesposiblesxpiezas t58=new posicionesposiblesxpiezas(41,43,48,52,999,999,999,999);
   posiciones [7][2]=t58;
   posicionesposiblesxpiezas t59=new posicionesposiblesxpiezas(42,44,49,53,999,999,999,999);
   posiciones [7][3]=t59;
    posicionesposiblesxpiezas t60=new posicionesposiblesxpiezas(43,45,50,54,999,999,999,999);
   posiciones [7][4]=t60;
    posicionesposiblesxpiezas t61=new posicionesposiblesxpiezas(44,46,51,55,999,999,999,999);
   posiciones [7][5]=t61;
    posicionesposiblesxpiezas t62=new posicionesposiblesxpiezas(45,47,52,999,999,999,999,999);
   posiciones [7][6]=t62;
   posicionesposiblesxpiezas t63=new posicionesposiblesxpiezas(46,53,999,999,999,999,999,999);
   posiciones [7][7]=t63;
   //cargada fila 8

  



  /*










   int []w={0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,32,21,22,24,25,26,27,28,30,7,34,56,34,45,46,47,48,49,50}; //piezas que hay q matar
 int ppm=3;      //ppm es la posicion del caballo negro que va a tener que matar a piezaspormatar[0]
  int resultado[];
 ArrayList caminofinal=new ArrayList();
 for (int u=0; u<w.length;u++){

 //esta es la posicion del caballo blanco que tenemos que matar, lo cargamos

 if(caminofinal.contains(w[u])==false)//significa que sin querer ya mate esta pieza anteriormente
    {
      piezaspormatar[0]=w[u]; //aca cargo las piezas por matar
      resultado= Main.buscar(ppm,0,999);
      resultado[resultado.length-1]=w[u];  //porque no devuelve la posicion objetivo como ulltima posicion (??)
      for (int j=0;j<resultado.length;j++){
      caminofinal.add(resultado[j]);
  }

  ppm=w[u];     //arrancar la proxima busqueda desde la posicion que mato
  }
}

 Object []q =caminofinal.toArray();
 Object j=1234;
 for (int y=0;y<q.length;y++){
   if(j!=q[y])
    System.out.println(q[y]);   //hay un problema ver hoja de apunte
  j=q[y];}
System.out.println("hhhhhhhhhhhhhhhhhhhhhhh");












/*

for (int v=0;v<resultado.size();v++){
System.out.println(resultado.get(v));
}*/
}   //el tema es q cuando mata 1 pieza termina todo, y tendria q seguir hasta matar todas!
  //int []p=posiciones[numero/8][numero-(8*(numero/8))].posibilidades();
   //for (int y=0; y<8;y++){
     //  if (p[y]<65){
       //System.out.println(p[y]);




   }



