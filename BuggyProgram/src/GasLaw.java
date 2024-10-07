//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static double GasConstant = 8.3143;

    //-----------------------------------------------------------------------------
    public static main(String[] args) {

//----Variables to hold system values
        double Volume, Moles, Temp;
        double pressure;

//----What is this all about?
        System.out.print("Enter volume, moles, temperature : ")
        Volume = keyboard.nextDouble();
        Moles = keyboard.nextDouble();
        Volume = keyboard.nextDouble();

//----Is anything happening here?
        pressure = Moles * GasConstant * Temp / Volume:

//----Why do this?
        System.out.println("Pressure is ", pressure);
    }
//-----------------------------------------------------------------------------
//=============================================================================