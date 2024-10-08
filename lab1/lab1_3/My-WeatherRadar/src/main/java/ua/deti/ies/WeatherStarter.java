package ua.deti.ies;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.deti.ies.ipma_client.IpmaCityForecast; //may need to adapt package name
import ua.deti.ies.ipma_client.IpmaService;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    private static int CITY_ID_AVEIRO = 1010500;

    private static Logger logger = LogManager.getLogger(WeatherStarter.class.getName());

    public static void  main(String[] args ) {

        if (args.length!=0){
            CITY_ID_AVEIRO = Integer.parseInt(args[0]);
        }

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                logger.info("City {} temp for {}", forecast.getGlobalIdLocal(), firstDay.getForecastDate());
                logger.info("Maximum Temperature is {}ºC", Double.parseDouble(firstDay.getTMax()));
                logger.info("Minimum Temperature is {}ºC", Double.parseDouble(firstDay.getTMin()));
                logger.info("Wind Direction is {}", firstDay.getPredWindDir());
                logger.info("Wind Speed is {} m/s", firstDay.getClassWindSpeed());
            } else {
                logger.info( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}