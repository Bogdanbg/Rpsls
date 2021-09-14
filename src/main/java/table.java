
import io.bretty.console.table.Alignment;
import io.bretty.console.table.*;

public class table {

    public static void createTable(Integer k, String[] args) {
        String value="";
        String[] ages;

        ColumnFormatter<String> nameFormatter = ColumnFormatter.text(Alignment.LEFT, 15);
        ColumnFormatter<String> valueFormatter = ColumnFormatter.text(Alignment.CENTER, 15);

        Table.Builder builder = new Table.Builder("User / Comp", args, nameFormatter);
        for (int i=0; i<k;i++) {
            ages = new String[k];
            for (int j=0;j<k;j++) {
                int q = Rules.calculate(i, j, k);
                if (q == 1) {value="WIN ";}
                if (q == 0) {value="DRAW";}
                if (q ==-1) {value="LOSE";}
                ages[j] = value;
            }
            builder.addColumn(args[i], ages, valueFormatter);
        }
        Table table = builder.build();
        System.out.println(table);

    }
}