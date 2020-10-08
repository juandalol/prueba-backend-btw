import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FechaPago {

    public static void main(String[] args) throws ParseException {

//        Complete la siguiente función, de tal manera que de acuerdo a los parámetros dados se aplique la lógica
//        necesaria para devolver la fecha de pago de quincena, el día hábil más cercano al día 15 o 30 ingresado
//        por el usuario, dando prioridad al anterior en caso de empate.
//        Nota: Puede hacer uso de los elementos externos que crea necesarios (base de datos, archivos, etc).

//        Ej: Si el usuario ingresa 15 de Noviembre que es domingo, y el próximo lunes es festivo, la fecha a
//        devolver será el viernes 13.
//        Si el usuario ingresa el día 30 de Marzo que es domingo y el lunes no es festivo, devolverá el lunes 31.
//        Si el usuario ingresa el día 15 de Junio que es miércoles, devolverá el mismo día.


        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor ingresar una fecha con el formato 'dd/MM/yyyy'");
        String fechaIng = sc.nextLine();




        System.out.println(fechaPago(fechaIng));
    }

    private static String fechaPago (String fechaIni) throws ParseException {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println(Calendar.DAY_OF_WEEK);
        List diasHabiles = new ArrayList();
        List domingosFestivos = new ArrayList();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String inicioAño = "01/01/2020";
        Date primerDia = df.parse(inicioAño);
        c.setTime(primerDia);
        for (int i = 0; i <= 366; i++) {
            diasHabiles.add(df.format(c.getTime()));
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.FRIDAY) {
                c.add(Calendar.DATE, 3);
            } else if (dayOfWeek == Calendar.SATURDAY) {
                c.add(Calendar.DATE, 2);
            } else {
                c.add(Calendar.DATE, 1);
            }
        }
        domingosFestivos.add("01/01/2020");
        domingosFestivos.add("06/01/2020");
        domingosFestivos.add("23/03/2020");
        domingosFestivos.add("09/04/2020");
        domingosFestivos.add("10/04/2020");
        domingosFestivos.add("01/05/2020");
        domingosFestivos.add("25/05/2020");
        domingosFestivos.add("15/06/2020");
        domingosFestivos.add("22/06/2020");
        domingosFestivos.add("29/06/2020");
        domingosFestivos.add("20/07/2020");
        domingosFestivos.add("07/08/2020");
        domingosFestivos.add("17/08/2020");
        domingosFestivos.add("12/10/2020");
        domingosFestivos.add("02/10/2020");
        domingosFestivos.add("16/11/2020");
        domingosFestivos.add("08/10/2020");
        domingosFestivos.add("25/10/2020");

        String diaEvaluar = fechaIni;
        boolean diaHabil = diasHabiles.contains(diaEvaluar);
        boolean diaFestivo = domingosFestivos.contains(diaEvaluar);
        if (diaHabil && !diaFestivo) {
            return diaEvaluar;
        } else {
            Date date = df.parse(diaEvaluar);
            c.setTime(date);
            System.out.println(date);
            boolean x = true;
            boolean y = true;
            String fechaArriba = " ";
            String fechaAbajo = " ";
            while (x) {
                c.add(Calendar.DAY_OF_YEAR, 1);
                String newDate = df.format(c.getTime());
                diaHabil = diasHabiles.contains(newDate);
                diaFestivo = domingosFestivos.contains(newDate);
                if (diaHabil && !diaFestivo) {
                    fechaArriba = newDate;
                    x = false;
                }
            }
            while (y) {
                c.add(Calendar.DAY_OF_YEAR, -1);
                String newDate = df.format(c.getTime());
                diaHabil = diasHabiles.contains(newDate);
                diaFestivo = domingosFestivos.contains(newDate);
                if (diaHabil && !diaFestivo) {
                    fechaAbajo = newDate;
                    y = false;
                }
            }

            Date dateAb = df.parse(fechaAbajo);
            Date dateArr = df.parse(fechaArriba);
            Date dateAc = df.parse(diaEvaluar);

            int diasAb = (int) ((dateAb.getTime() - dateAc.getTime()) / 86400000);
            int diasArr = (int) ((dateAc.getTime() - dateArr.getTime()) / 86400000);
            //int diasDif= (int) ((dateArr.getTime()-dateAb.getTime())/86400000);

            if (diasAb == diasArr) {
                return fechaAbajo;
            } else if (diasAb < diasArr) {
                return fechaArriba;
            } else {
                return fechaAbajo;
            }
        }
    }
}