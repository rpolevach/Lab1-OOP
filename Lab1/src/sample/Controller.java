package sample;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane createTrain;

    @FXML
    private ComboBox<?> trainList;

    @FXML
    private ComboBox<?> wagonList;

    @FXML
    private MenuItem addWagon, addSeat;

    @FXML
    private Pane infoTable;

    @FXML
    private TextField WagonNumber;

    @FXML
    private TextField trainNumber;

    @FXML
    private Pane createWagon;

    @FXML
    private Pane createSeat;

    @FXML
    private Label infoWindow;

    @FXML
    private TextField seatNumber;

    //Функция для открытия слоя с созданием поезда
    @FXML
    void createTrainMenu(ActionEvent event)
    {
        hidePanes(false, true, true, true);
        infoWindow.setText("Создание поезда");
    }

    //Функция для кнопки "Создать поезд"
    @FXML
    void createTrainButton(ActionEvent event)
    {
        //Проверка на корректность введенных данных
        boolean error = true;
        if (trainNumber.getText().equals(""))
        {
            infoWindow.setText("Пожалуйста, введите номер поезда!");
            error = false;
        }
        if (error)
        {
            for (int i = 0; i < trains.size(); i++)
            {
                if (trains.get(i).getTrainNumber().equals(trainNumber))
                {
                    infoWindow.setText("Поезд с таким номером уже существует!");
                    error = false;
                    break;
                }
            }
        }
        if (error)
        {
            //Добавление поезда в класс Train
            trains.add(new Train(trainNumber.getText()));
            infoWindow.setText("Информация успешно сохранена!");
            addWagon.setDisable(false);
        }
    }

    @FXML
    void createWagonMenu(ActionEvent event) {

    }

    @FXML
    void createSeatMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert createTrain != null : "fx:id=\"createTrain\" was not injected: check your FXML file 'sample.fxml'.";
        assert trainList != null : "fx:id=\"trainList\" was not injected: check your FXML file 'sample.fxml'.";
        assert wagonList != null : "fx:id=\"wagonList\" was not injected: check your FXML file 'sample.fxml'.";
        assert infoTable != null : "fx:id=\"infoTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert WagonNumber != null : "fx:id=\"WagonNumber\" was not injected: check your FXML file 'sample.fxml'.";
        assert trainNumber != null : "fx:id=\"trainNumber\" was not injected: check your FXML file 'sample.fxml'.";
        assert createWagon != null : "fx:id=\"createWagon\" was not injected: check your FXML file 'sample.fxml'.";
        assert createSeat != null : "fx:id=\"createSeat\" was not injected: check your FXML file 'sample.fxml'.";
        assert infoWindow != null : "fx:id=\"infoWindow\" was not injected: check your FXML file 'sample.fxml'.";
        assert seatNumber != null : "fx:id=\"seatNumber\" was not injected: check your FXML file 'sample.fxml'.";

    }

    private ArrayList<Train> trains = new ArrayList<>();
    private ArrayList<Wagon> wagons = new ArrayList<>();
    private ArrayList<Seat> seats = new ArrayList<>();

    //Функция скрытия слоев
    public void hidePanes(boolean createTrain, boolean createWagon, boolean createSeat, boolean infoTable)
    {
        if (createTrain)
        {
            this.createTrain.setVisible(false);
        }
        else
        {
            this.createTrain.setVisible(true);
        }
        if (createWagon)
        {
            this.createWagon.setVisible(false);
        }
        else
        {
            this.createWagon.setVisible(true);
        }
        if (createSeat)
        {
            this.createSeat.setVisible(false);
        }
        else
        {
            this.createSeat.setVisible(true);
        }
        if (infoTable)
        {
            this.infoTable.setVisible(false);
        }
        else
        {
            this.infoTable.setVisible(true);
        }
    }

}
