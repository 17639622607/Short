package mdao.util;

import mdao.client.H5Client;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadH5  {
    public static int success=0;//成功数
    public static int fail=0;//成功数
    public static int sleep=3;
    public static void main(String[] args) {
        int startN=1;//决定开启几个线程
        List<String> list=new ArrayList<>();
        list=GetExcle.getExcle("D:\\test.xlsx");
        int count=list.size();
        DecimalFormat df = new DecimalFormat("0.000");
        long start = System.currentTimeMillis();
        //主线程等待，降为0时主线程也准备结束，防止副线程没执行完之前主线程结束
        final CountDownLatch latch=new CountDownLatch(startN);
        H5Client h5Client=new H5Client();
        //将号码分割
        List<List<String>> lstgroupmibble= TestArray2.groupList(list,count%startN==0?count/startN:count/startN+1);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程1启动");
                try {
                   List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(0),sleep);
                    for ( boolean b:listflag
                         ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程2启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(1),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程3启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(2),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程4启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(3),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t5 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程5启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(4),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t6 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程6启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(5),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t7 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程7启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(6),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t8 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程8启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(7),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t9 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程9启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(8),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        Thread t10 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程10启动");
                try {
                    List<Boolean> listflag= MoreH5.moreH5(lstgroupmibble.get(9),sleep);
                    for ( boolean b:listflag
                    ) {
                        if (b){
                            success++;
                        }else
                            fail++;
                    }
                    Thread.sleep(sleep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();//让latch种的数值减1
            }
        };
        switch (startN){
            case 10:
                t1.start();t2.start();t3.start();t4.start();t5.start();t6.start();t7.start();t8.start();t9.start();t10.start();
                break;
            case 9:
                t1.start();t2.start();t3.start();t4.start();t5.start();t6.start();t7.start();t8.start();t9.start();
                break;
            case 8:
                t1.start();t2.start();t3.start();t4.start();t5.start();t6.start();t7.start();t8.start();
                break;
            case 7:
                t1.start();t2.start();t3.start();t4.start();t5.start();t6.start();t7.start();
                break;
            case 6:
                t1.start();t2.start();t3.start();t4.start();t5.start();t6.start();
                break;
            case 5:
                t1.start();t2.start();t3.start();t4.start();t5.start();
                break;
            case 4:
                t1.start();t2.start();t3.start();t4.start();
                break;
            case 3:
                t1.start();t2.start();t3.start();
                break;
            case 2:
                t1.start();t2.start();
                break;
            case 1:
                t1.start();
                break;
        }
        //让主线程等待
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();//程序结束的时间
        float num=(float)success/(count);
        System.out.println("线程数:"+startN+"间隔:"+sleep+" 用时:"+(end-start)+" 请求次数:"+count+" 成功数:"+success+" 失败数:"+fail);
        System.out.println("成功率:"+Float.parseFloat(df.format(num))*100+"%");
    }


}
