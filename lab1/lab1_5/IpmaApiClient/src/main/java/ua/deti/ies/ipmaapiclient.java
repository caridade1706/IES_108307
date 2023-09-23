package ua.deti.ies;


import java.io.IOException;
import java.util.*;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.deti.ies.ipma_client.IpmaCityForecast; //may need to adapt package name
import ua.deti.ies.ipma_client.IpmaService;
import ua.deti.ies.ipma_client.CityForecast;
import ua.deti.ies.ipma_client.Cities;
import ua.deti.ies.ipma_client.City;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class ipmaapiclient {

    //todo: should generalize for a city passed as argument
    //private static int CITY_ID_AVEIRO = 1010500;
    

    public static CityForecast getInfo (Integer randomid){


        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);

        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(randomid);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                return (forecast.getData().listIterator().next());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static City getCity() throws IOException{
        List<City> cities_info = new ArrayList<>();

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);

        // devolve os global ids de todos as cidades numa lista

        Call<Cities> cities = service.getAll();
        Response<Cities> apiCities = cities.execute();
        Cities apiCitiesResp = apiCities.body();
        for(City i : apiCitiesResp.getData()){

            cities_info.add(i);
        }
        Random random = new Random();

        // Gerar um índice aleatório dentro dos limites da lista
        int randomIndex = random.nextInt(cities_info.size());

        // Obter o elemento aleatório da lista
        City randomid = cities_info.get(randomIndex);


        return randomid;

        
    }
}