package task5;

public class Main {

        //------Variant 1--------
    public static void main(String[] args) {
//        Runnable dashRunnable = () -> {
//            for (int i = 0; i < 100; i++) {
//                SymbolPrinter.printSymbols('-', 100);
//            }
//        };
//
//        Runnable pipeRunnable = () -> {
//            for (int i = 0; i < 100; i++) {
//                SymbolPrinter.printSymbols('|', 100);
//            }
//        };
//
//        Thread threadA = new Thread(dashRunnable);
//        Thread threadB = new Thread(pipeRunnable);
//
//        threadA.start();
//        threadB.start();
//    }

    //--------Variant2--------

            SymbolPrinter2 symbolPrinter = new SymbolPrinter2();

            Runnable dashRunnable = () -> symbolPrinter.print('-', true);

            Runnable pipeRunnable = () -> symbolPrinter.print('|', false);

            Thread threadA = new Thread(dashRunnable);
            Thread threadB = new Thread(pipeRunnable);

            threadA.start();
            threadB.start();
        }
    }
