package com.imooc;

public class VolatileDemo {
	
	private int number = 0;
	
	public int getNumber(){
		return this.number;
	}
	
	public void increase(){
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		synchronized(this){
			this.number++ ;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final VolatileDemo volatileDemo = new VolatileDemo();
		for (int i = 0; i<500; i++){
			new Thread(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					volatileDemo.increase();
				}
			}).start();
		}
		
		//����������߳���ִ�У����߳��ó�CPU��Դ��ֱ�����е����߳�ִ���꣬���̲߳ż���ִ�У���ӡnumber��ֵ
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		System.out.println("number = " + volatileDemo.getNumber());
	}

}
