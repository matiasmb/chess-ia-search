/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess_horse;

/**
 *
 * @author db2admin
 */

public class posicionesposiblesxpiezas {
int []o=new int[8];

 posicionesposiblesxpiezas (int a,int b,int c,int d,int e,int f,int g,int h){
o[0]=a;
o[1]=b;
o[2]=c;
o[3]=d;
o[4]=e;
o[5]=f;
o[6]=g;
o[7]=h;
}
void carga (int a,int b,int c,int d,int e,int f,int g,int h){
o[0]=a;
o[1]=b;
o[2]=c;
o[3]=d;
o[4]=e;
o[5]=f;
o[6]=g;
o[7]=h;
}
 int[] posibilidades(){
int l[]=new int[8];
l[0]=this.o[0];
l[1]=this.o[1];
l[2]=this.o[2];
l[3]=this.o[3];l[4]=this.o[4];l[5]=this.o[5];l[6]=this.o[6];l[7]=this.o[7]; return(l);
};



};



