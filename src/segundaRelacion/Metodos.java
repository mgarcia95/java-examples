package segundaRelacion;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Metodos {
	//IMPRIME EJERCICIO
	void imprimeEjercicio(Integer numeroejercicio) {
		System.out.println("Ejercicio "+numeroejercicio+": ");
	}
	//EJERCICIO 1:
	private void recorreDimension(Integer[] n){
		for(int i=0; i<n.length;i++) System.out.print(n[i]+" ");
		System.out.println("");
	}
	private Integer [] generaArray(Integer arraysize) {
		Integer [] array = new Integer[arraysize];
		for(int i=0;i<array.length;i++) array[i]=(int) (Math.random()*10);
		return array;
		
	}
	void generarecorreArray(Integer n) {
		Integer [] i=generaArray(n);
		recorreDimension(i);
	}
	//EJERCICIO 2:
	private Integer [] generaArrayTeclado(Integer n) {
		Integer [] array = new Integer [n];
		for(int i=0;i<array.length;i++) {
			System.out.print("Introduce un número: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			array[i]=sc.nextInt();
		}
		return array;
	}
	void generarecorreArrayTeclado(Integer arraysize) {
		Integer [] i=generaArrayTeclado(arraysize);
		recorreDimension(i);
	}
	//EJERCICIO 3:
	private void calculaPositivosArray(Integer [] array) {
		Integer positivos = 0;
		Integer negativos = 0;
		Integer zero = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]>0) positivos++;
			else if (array[i]<0) negativos ++;
			else zero++;
		}
		System.out.println("Positivos: "+positivos);
		System.out.println("Negativos: "+negativos);
		System.out.println("Cero: "+zero);
	}
	void positivosAleatoriosArrayTeclado(Integer n) {
		Integer [] i = generaArrayTeclado(n);
		calculaPositivosArray(i);
		
	}
	//EJERCICIO 4:
	private Integer calculaMayorArray(Integer [] array) {
		Integer mayor = array[0];
		Integer posicion = 0;
		for(int i=1;i<array.length;i++) {
			if(array[i]>mayor) {
				mayor=array[i];
				posicion=i;
			}
		}
		return posicion;
	}
	void calculaMayorArrayAleatorio(Integer arraysize) {
		Integer [] i = generaArray(arraysize);
		recorreDimension(i);
		System.out.println("La posición del número más grande está en la posicion: "+calculaMayorArray(i)+" y tiene como valor: "+i[calculaMayorArray(i)]);
	}
	//EJERCICIO 5:
	private Double mediaPar(Integer [] array) {
		Double media = 0.0;
		Integer cont = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]%2==0) {
				media=media+array[i];
				cont++;
			}
		}
		return media/cont;
	}
	void generaMediaPar(Integer arraysize) {
		Integer[] i = generaArray(arraysize);
		recorreDimension(i);
		System.out.println("La media de los números pares introducidos es:" +mediaPar(i));
	}
	//EJERCICIO 6:
	private Integer [] generaArray(Integer min, Integer max) {
		int cont=0;
		while(cont==0) {
			System.out.print("Indica el tamaño del Array: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			Integer size = sc.nextInt();
			if(size>=min && size<=max) cont=size;
		}
		return generaArray(cont);	
	}
	private void compruebaArray(Integer [] array) {
		System.out.print("Introduzca el número a buscar: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Integer check = sc.nextInt();
		Integer cont=0;
		for(int i=0; i<array.length;i++) {
			if(array[i]==check) {
				System.out.println("Numero encontrado en la posición "+i);
				cont++;
			}
		}
		System.out.println("El número ha sido encontrado "+cont+" veces.");
	}
	void generaArrayImprimeComprueba() {
		Integer n[]=generaArray(1,100);
		recorreDimension(n);
		compruebaArray(n);
	}
	//EJERCICIO 7:
	private Boolean compruebaPositivo(Integer n){
		if(n>0) {
			return true;
		}
		else return false;
	}
	void calculaCompruebaTeclado(Integer arraysize) {
		Integer []n = generaArrayTeclado(arraysize);
		Integer positivo = 0, contpos=0, negativo=0, contneg=0;
		for(int i=0;i<n.length;i++) {
			if(compruebaPositivo(n[i])) {
				positivo=positivo+n[i]; 
				contpos++;
			}
			else {
				negativo=negativo+n[i];
				contneg++;
			}
		}
		recorreDimension(n);
		System.out.println("La media de positivos es: "+(double)positivo/contpos);
		System.out.println("La media de negativos es: "+(double)negativo/contneg);
	}
	//EJERCICIO 8:
	private Integer[] ordenaArray(Boolean mayormenortrue888menormayorfalse, Integer[] array) {
		if(mayormenortrue888menormayorfalse) {
			for(int i=0;i<array.length;i++) {
				for(int j=0;j<array.length-1;j++) {
					if(array[j]<array[j+1]) {
						int vaso=0;
						vaso=array[j+1];
						array[j+1]=array[j];
						array[j]=vaso;
					}
				}
			}
		}
		else {
			for(int i=0;i<array.length;i++) {
				for(int j=0;j<array.length-1;j++) {
					if(array[j]>array[j+1]) {
						int vaso=0;
						vaso=array[j+1];
						array[j+1]=array[j];
						array[j]=vaso;
					}
				}
			}
		}
		return array;
	}
	private Integer [] generaAleatorioCantidad(int min, int max, int arraysize) {
		Integer[] n = new Integer[arraysize];
		for(int i=0;i<n.length;i++) {
			n[i]=(int)(Math.random()*max)+min;
		}
		return n;
	}
	void generaImprimeMuestra(Integer arraysize) {
		Integer array[]=generaAleatorioCantidad(1,60,arraysize);
		recorreDimension(array);
		Integer[] arraymayor=ordenaArray(true,array);
		System.out.println("El numero mayor es "+arraymayor[0]);
		System.out.println("El numero menor es "+arraymayor[array.length-1]);
		Integer promedio = 0;
		for(int n:array) promedio=promedio+n;
		System.out.println("La media es "+(double)promedio/array.length);
	}
	//EJERCICIO 9:
	private Integer[] invierteArray(Integer[] array) {
		for(int i=0;i<array.length/2;i++) {
			int vaso=array[i];
			array[i]=array[array.length-(i+1)];
			array[array.length-(i+1)]=vaso;
			
		}
		return array;
	}
	void generaAleatorioMuestraInverso() {
		Integer array[]=generaAleatorioCantidad(1,50,20);
		recorreDimension(array);
		recorreDimension(invierteArray(array));
	}
	//EJERCICIO 10:
	private Integer[] uneArray(Integer[] array1, Integer[] array2) {
		Integer [] union = new Integer[array1.length+array2.length];
		Integer cont=0;
		for(int i = 0;i<(array1.length+array2.length);i++) {
			if(i<array1.length) union[i]=array1[i];
			else {
				union[i]=array2[cont];
				cont++;
			}
		}
		return union;
	}
	void generauneArray(Integer tam1, Integer tam2) {
		Integer[] array1 = generaArray(tam1);
		recorreDimension(array1);
		Integer[] array2 = generaArray(tam2);
		recorreDimension(array2);
		Integer[] arrayunion = uneArray(array1, array2);
		recorreDimension(arrayunion);
	}
	//EJERCICIO 11:
	void generaUneArrayMayorMenor(Integer tam1, Integer tam2, Boolean mayormenortrue888menormayorfalse) {
		Integer[] array1 = generaArray(tam1);
		recorreDimension(array1);
		Integer[] array2 = generaArray(tam2);
		recorreDimension(array2);
		Integer[] arrayunion = uneArray(array1, array2);
		recorreDimension(arrayunion);
		recorreDimension(ordenaArray(mayormenortrue888menormayorfalse,arrayunion));
	}
	//EJERCICIO 12:
	void calculaMedia(){
		int cantidad = 0;
		for(int i=0;i>-1;i++) {
			System.out.print("Dime cuantas alturas genero: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int n= sc.nextInt();
			if(n>0) {
				cantidad=n;
				i=-10;
			}
		}
		Double [] altper = new Double[cantidad];
		for(int i=0;i<altper.length;i++) {
			altper[i]=Math.random()*(2.0-1.5)+1.5;
			System.out.println(altper[i]);
		}
		Double media = 0.0;
		Integer contador=0;
		for(Double n : altper) {
			media = media + n;
			contador++;
		}
		Integer supmedia=0;
		Integer infmedia=0;
		for (Double n:altper) {
			if(n>media/contador)supmedia++;
			else infmedia++;
		}
		System.out.println("La media es "+media/contador);
		System.out.println("Hay "+supmedia+" personas que superan la media");
		System.out.println("Hay "+infmedia+" personas que no superan la media");	
	}
	//EJERCICIO 13
	private Vector<Integer> generaVectorAleatorio(Integer vectorsize, Integer max, Integer min) {
		Vector<Integer> v = new Vector<Integer>(vectorsize, 1); //El uno especifica en cuanto se incrementara el vector si superamos el tamaño que este tiene.
		for(int i=0;i<=vectorsize;i++) {
			v.addElement((int) (Math.random()*(max-min)+min));
		}
		return v;
	}
	private void recorreVector(Vector<Integer> v) {
		for(int i=0;i<v.size();i++) {
			System.out.print(v.elementAt(i)+" ");
		}
	}
	void generabuscaVector(Integer vectorsize, Integer max, Integer min) {
		Vector<Integer> v = generaVectorAleatorio(vectorsize, max, min);
		for(int i=0;i<v.size();i++) {
			if (v.elementAt(i)%10==4) {
				System.out.println("Número terminado en 4 encontrado en la posición "+i);
			}
		}
		recorreVector(v);
	}
	//EJERCICIO 14:
	private Boolean compruebaPrimo(Integer numero) {
		int contador = 2;
		boolean primo=true;
		 
		while (primo && contador!=numero){
		  if (numero%contador==0)
		    primo = false;
		  contador++;
		}
		return primo;
	}
	private Vector<Integer> rellenaVectorPrimos() {
		Vector<Integer> v = new Vector<Integer>(10,1);
		Integer cont=0;
		Integer inicio=100;
		while(cont<10) {
			if(compruebaPrimo(inicio)) {
				v.add(inicio);
				cont++;
			}
			inicio++;
		}
		return v;
	}
	void rellenaImprimeVectorPrimos() {
		Vector <Integer> v = rellenaVectorPrimos();
		recorreVector(v);
	}
	//EJERCICIO 15:
	void buscarMayorPrimo() {
	Vector <Integer> v = generaVectorAleatorio(10,1,100);
	Vector <Integer> primos = new Vector<Integer>(1,1);
	for(int i=0;i<v.size();i++) {
		if(compruebaPrimo(v.elementAt(i))) {
			primos.add(v.elementAt(i));
		}
	}
	Integer mayor=primos.elementAt(0);
	for(int i=1;i<primos.size();i++) {
		if(mayor<primos.elementAt(i)) {
			mayor=primos.elementAt(i);
		}
	}
	recorreVector(v);
	System.out.println(" ");
	recorreVector(primos);
	System.out.println(" ");
	System.out.println("El primo mayor es: "+mayor);
	}
	//EJERCICIO 16:
	Integer calculaFactorial(Integer n) {
		Integer factorial=n;
		for(int i=n-1;i>0;i--) {
			factorial=factorial*(i);
		}
		return factorial;
	}
	void calculaFactorialVector() {
		Vector <Integer> v= generaVectorAleatorio(10,1,12);
		Vector <Integer> vector_factoriales = new Vector<Integer>(1,1);
		for(int i=0;i<v.size();i++) {
			vector_factoriales.add(calculaFactorial(v.elementAt(i)));
		}
		recorreVector(v);
		System.out.println(" ");
		recorreVector(vector_factoriales);
	}
	//EJERCICIO 17:
	private void recorreNumero(Vector<Integer> v) {
		for(int i=0;i<v.size();i++) {
			Integer n = v.elementAt(i);
			for(int j=n;j>0;j--) System.out.print(j+" ");
			System.out.println(" ");
		}
	}
	void recorreNumeroCreaVector() {
		Vector <Integer> v = generaVectorAleatorio(10,1,10);
		recorreVector(v);
		System.out.println(" ");
		recorreNumero(v);
	}
	//EJERCICIO 18:
	private void mostrarMatriz(int[][] mtz){
		for(int i=0;i<mtz.length;i++){
			for(int j=0;j<mtz[i].length;j++){
				System.out.printf("%5d", mtz[i][j]);
			}
			System.out.println();
		}		
	}
	void mostrarMatrim() {
		int m[][]=new int [6][5];
		Random rd=new Random();
		for(int i=0;i<m.length;i++){
				for(int j=0;j<m[i].length;j++){
					m[i][j]=rd.nextInt(100);
				}
			}
			mostrarMatriz(m);
	}
	//EJERCICIO 19:
	void generaTraspuesta() {
		int[][] m={{1,2,3},{4,5,6},{7,8,9}};
		int [][] m1=new int[m.length][m[0].length];
		
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				m1[j][i]=m[i][j];
			}
		}
		mostrarMatriz(m);
		System.out.println();
		mostrarMatriz(m1);
	}
	//EJERCICIO 20:
	void ejercicio20() {
		int[][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12},{1,2,3,4},{5,6,7,8},{9,10,11,12},{0,0,0,0}};
		System.out.println();
		for(int co=0;co<4;co++){
			for(int fi=0;fi<6;fi++){
				m[6][co]=m[6][co]+m[fi][co];
			}
		}
		for(int f=0;f<7;f++){
			for(int c=0;c<4;c++){
				System.out.printf("%3d",m[f][c]);
			}
			System.out.println();
		}
	}
}