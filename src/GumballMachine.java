public class GumballMachine {
    IState soldOutState;
    IState noQuarterState;
    IState hasQuarterState;
    IState soldState;

    IState state;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        noQuarterState = new NoQuarterState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count -1;
        }
    }

    int getCount() {
        return count;
    }

    public void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new " +
                "count is: " + this.count);
        state.refill();
    }

    void setState(IState state) {
        this.state = state;
    }

    public IState getState() {
        return state;
    }

    public IState getSoldOutState() {
        return soldOutState;
    }

    public IState getNoQuarterState() {
        return noQuarterState;
    }

    public IState getHasQuarterState() {
        return hasQuarterState;
    }

    public IState getSoldState() {
        return soldState;
    }

      public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        result.append("\n");
        return result.toString();
    }
}
