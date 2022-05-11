class Calc {
    public static void main(String[] args) {
        // ln(2) = 0,693147180559945309417232121458176568075500134360255224
        System.out.printf("\nSérie i(10) %.12f\n", calc_partial_sum(10));
        // R = 0.693147180559 - 0.645634920635 = 0.047512259924
        System.out.printf("\nSérie i(100) %.12f\n", calc_partial_sum(100));
        // R = 0.693147180559 - 0.688172179310 = 0.004975001249
        System.out.printf("\nSérie i(1000) %.12f\n", calc_partial_sum(1000));
        // R = 0.693147180559 - 0.692647430560 = 0.000499749999
        calc_partial_sum_error_i();

        // (pi^2)/6 = 1.64493406684822643647241516664602518921894993751058209
        System.out.printf("\nSérie ii(10) %.12f\n", calc_partial_sum2(10));
        // R = 1,644934066848 - 1,549767731167 = 0.095166335681
        System.out.printf("\nSérie ii(100) %.12f\n", calc_partial_sum2(100));
        // R = 1.644934066848 - 1.634983900185 = 0.009950166663
        System.out.printf("\nSérie ii(1000) %.12f\n", calc_partial_sum2(1000));
        // R = 1.644934066848 - 1.643934566682 = 0.000999500166
        calc_partial_sum_error_ii();
        
        // e = 2.7182818284590452353602874713526624977572470936999595749
        System.out.printf("\nSérie iii(10) %.12f\n", calc_partial_sum3(10));
        // R = 2.718281828459 - 1.718281801146 = 1.000000027313
        System.out.printf("\nSérie iii(100) %.12f\n", calc_partial_sum3(100));
        // R = 2.718281828459 - Infinity = - Infinity
        System.out.printf("\nSérie iii(1000) %.12f\n", calc_partial_sum3(1000));
        // R = 2.718281828459 - Infinity = - Infinity
        calc_partial_sum_error_iii();

    }

    public static double calc_partial_sum(int n) {
        double soma = 0;
        while(n > 0) {
            soma = soma + Math.pow(-1, n) / n;
            n--;
        }
        return soma;

        // if (n == 1) {
        //     return (Math.pow(-1, n)) / n;
        // }
        // return (calc_partial_sum(n - 1) + ((Math.pow(-1, n)) / n));
    }

    public static double calc_partial_sum2(int n) {
        double soma = 0;
        while(n > 0) {
            soma = soma + (1 / (Math.pow(n, 2)));
            n--;
        }
        return soma;

        // if (n == 1) {
        //     return 1 / (Math.pow(n, 2));
        // }
        // return (calc_partial_sum2(n - 1) + (1 / (Math.pow(n, 2))));
    }

    public static double calc_partial_sum3(int n) {
        double soma = 0;
        while(n > 0) {
            soma = soma + (1 / (double)fat(n) );
            n--;
        }
        return soma;

        // if (n == 1) {
        //     return 1 / fat(n);
        // }
        // return (calc_partial_sum3(n - 1) + 1 / fat(n));
    }

    public static int fat(int n) {
        int fatorial = 1;
        while(n > 0) {
            fatorial = fatorial * n;
            n--;
        }
        return fatorial;
        // if (n == 1) {
        //     return 1;
        // }
        // return (n * fat(n - 1));
    }

    public static void calc_partial_sum_error_i() {
        int n = 999990; //menor valor de n para estabilidade 999999
        while(Math.abs(calc_partial_sum(n+1) - calc_partial_sum(n)) >= 0.000001){
            n++;
        }
        System.out.printf("\nN estável para Série i: %d\n", n);
    }
    public static void calc_partial_sum_error_ii() {
        int n = 900; //999
        while(Math.abs(calc_partial_sum2(n+1) - calc_partial_sum2(n)) >= 0.000001){
            n++;
        }
        System.out.printf("\nN estável para Série ii: %d\n", n);
    }
    public static void calc_partial_sum_error_iii() {
        int n = 1; //9
        while(Math.abs(calc_partial_sum3(n+1) - calc_partial_sum3(n)) >= 0.000001){
            n++;
        }
        System.out.printf("\nN estável para Série iii: %d\n", n);
    }

}
