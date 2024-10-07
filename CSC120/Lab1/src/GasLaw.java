import java.util.Scanner;

//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static final double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume, moles, temperature;
        double pressure;

//----Gathers value for variable
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

//----Calculates value for pressure
        pressure = (moles * GAS_CONSTANT * (temperature / volume));

//----Print result
        System.out.println("Pressure is " + pressure);
    }
}
//-----------------------------------------------------------------------------
//=====================g========================================================