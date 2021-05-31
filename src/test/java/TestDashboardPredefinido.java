import ar.mil.cideso.CidesoDashboard;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * En este test solo se le pasan los datos crudos y se arman los graficos necesarios para el dashboard
 */
public class TestDashboardPredefinido extends Application {

    public static void main(
            String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(
            Stage primaryStage) {

        List<Integer> data = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 33; i++)
            data.add(Math.abs(random.nextInt() % 6));

        // DASHBOARD COMPLETO
        CidesoDashboard.getInstance().getCompleteDashboardPane(
                "Vista General (Br. Mec. XI)",
                1366,
                768,
                data)
                .show();

    }

}
