package ua.deti.ies;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import ua.deti.ies.ipma_client.CityForecast;
import ua.deti.ies.ipma_client.City;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class anycityforecast {
    public static City city;
    public static CityForecast city_id;

    private static Logger logger = LogManager.getLogger(anycityforecast.class.getName());

    public static void main(String[] args) {
        Timer timer = new Timer();
        int interval = 20000; // Intervalo de 20 segundos em milissegundos

        // Agende a tarefa para ser executada repetidamente a cada 20 segundos
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    city = ipmaapiclient.getCity();
                    city_id = ipmaapiclient.getInfo(city.getGlobalIdLocal());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (city_id != null) {
                        logger.info("---------------------------------------\n");
                        logger.info("City {} Temperature for {} \n",
                            city.getLocal(),
                            city_id.getForecastDate());
                        logger.info("Maximum Temperature is {}ºC \n",
                            Double.parseDouble(city_id.getTMax()));
                        logger.info("Minimum Temperature is {}ºC \n",
                            Double.parseDouble(city_id.getTMin()));
                        logger.info("Wind Direction is {} \n",
                            city_id.getPredWindDir());
                        logger.info("Wind Speed is {}  \n",
                            city_id.getClassWindSpeed());
                        logger.info("Probability of Percipitation is {}% \n",
                            city_id.getPrecipitaProb());
                        logger.info("---------------------------------------\n");
                } else {
                    logger.info("No results for this request!");
                }
            }
        }, 0, interval); // Inicia imediatamente e depois repete a cada 20 segundos
    }
}
