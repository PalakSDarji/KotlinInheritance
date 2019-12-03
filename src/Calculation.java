public abstract class Calculation {

    String eldHelper;
    static String selectedCycle = "Canada";//US

    public Calculation() {
        eldHelper = "EldHelperrrr";
    }

    abstract String thisIsAbstractMethod();

    String getStatusInMin(){
        return "return from Calculation. Common";
    }

    public static void main(String[] args){

        Calculation calculation = getObjectFromSelectedCycle(selectedCycle);
        System.out.println(calculation.getStatusInMin());

        calculation.thisIsAbstractMethod();
        if(calculation instanceof CanadaHosCalculation){
            ((CanadaHosCalculation) calculation).getCanadaSpecificString();
        }

    }

    static Calculation getObjectFromSelectedCycle(String selectedCycle){
        if(selectedCycle.equals("US")){
            return new USHosCalculation();
        }
        else{
            return new CanadaHosCalculation();
        }
    }

}

class USHosCalculation extends Calculation{

    String getUsSpecificMethod(){
        return "this is UsSpecificMethod impl";
    }

    @Override
    String thisIsAbstractMethod() {
        return null;
    }
}

class CanadaHosCalculation extends Calculation{

    String canadaSpecificString = "canadaSpecificString";

    @Override
    String thisIsAbstractMethod() {
        return null;
    }

    @Override
    String getStatusInMin() {
        System.out.println("we can use eldhelper which is in base class " + eldHelper +" and "+ canadaSpecificString +" in Canada.");
        return super.getStatusInMin();
    }

    String getCanadaSpecificString(){
        return canadaSpecificString;
    }

    String getCanadaSpecificMethod(){
        return "this is CanadaSpecificMethod impl";
    }
}

