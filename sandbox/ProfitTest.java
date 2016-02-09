import org.junit.*;
import static org.junit.Assert.*;

public class ProfitTest {

    @Test
    public void should_calculate_total_profits_for_the_year_in_Java6() {
        // given
        final double[] EXPECTED_SALES_JAN_TO_DEC =
            new double[] { 42.0, 45.6, 43.6, 50.2, 55.6, 54.7,
                    58.0, 57.3, 62.0, 60.3, 71.2, 88.8};
        final Sales sales = new Sales(
                FunctionOverTimeUtil.monthByMonth(EXPECTED_SALES_JAN_TO_DEC));

        final FixedCosts fixedCosts = new FixedCosts(
                FunctionOverTimeUtil.constant(15.0));

        final IncrementalCosts incrementalCosts =
                new IncrementalCosts(
                FunctionOverTimeUtil.line(5.1, 0.15));

        final Profit profit =
                new Profit(
                        sales,
                        fixedCosts,
                        incrementalCosts);

        // when
        double totalProfit = 0.0;
        for(int time = 1; time <= 12; time ++) {
            totalProfit += profit.valueAt(time);
        }

        // then
        assertEquals(436.4, totalProfits, 0.001);
    }
}
