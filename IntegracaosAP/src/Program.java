import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;

public class Program {

	
	public static void main(String[] args) throws JCoException {

        JCoDestination destination = JCoDestinationManager.getDestination("ABAP_AS");
        JCoFunction function = destination.getRepository().getFunction("Z_GET_SCAR");
		
        function.getImportParameterList().setValue("I_CARRID", "ZZZ");
        try {
            function.execute(destination);
            System.out.println(function.getExportParameterList().getString("E_CARRNAME"));
        }
        catch (JCoException ex) {
            if (ex.getKey().equals("CARR_NOT_FOUND")) {
                System.out.println("Não foi encontrado uma Cia. Aérea com o código informado.");
            }
        }
        System.out.println();
    }
	
}
