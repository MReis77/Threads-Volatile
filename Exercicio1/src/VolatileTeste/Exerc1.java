package VolatileTeste;

public class Exerc1 {
	
	 private  volatile int a = 0;
	 private volatile int b = 0;
	 private boolean parar = false;

	public static void main(String[] args) {
		 Exerc1 teste = new Exerc1();
		 teste.executar();

		 }

		 public void executar() {
		 
		 new Thread(new Runnable() {

		 @Override
		 public void run() {
		 while(!parar) {
		 incrementar();
		 }
		 }
		 }).start();
		 
		 new Thread(new Runnable() {
		 @Override
		 public void run() {
		 while(!parar) {
		 verificar();
		 }
		 }
		 }).start();
		 }
		 
		 public void incrementar() {
		 a++;
		 b++;
		 if(a == Integer.MAX_VALUE) {
		 a = 0;
		 b = 0;
		 } 
		 }
		 
		 public void verificar() {
		 if(b > a) {
		 System.out.println("ERROR 404. a = " + a + " b = " + b);
		 this.parar = true;
		 }
		 else {
		 System.out.println("Tudo numa boa. a = " + a + " b = " + b); 
		 }
		 } 
		}