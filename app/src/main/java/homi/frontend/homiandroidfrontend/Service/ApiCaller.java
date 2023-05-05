package homi.frontend.homiandroidfrontend.Service;

import homi.frontend.homiandroidfrontend.Models.CompleteSingleAnimalModel;
import homi.frontend.homiandroidfrontend.Response.AnimalNotesResponse;
import homi.frontend.homiandroidfrontend.Response.AnimalSimpleResponse;
import homi.frontend.homiandroidfrontend.Response.CompleteSingleAnimalResponse;
import homi.frontend.homiandroidfrontend.Response.MatingResponse;
import homi.frontend.homiandroidfrontend.Response.OrderGroupsResponse;
import homi.frontend.homiandroidfrontend.Response.PastureGroupConnectorResponse;
import homi.frontend.homiandroidfrontend.Response.PastureGroupResponse;
import homi.frontend.homiandroidfrontend.Response.PastureResponse;
import homi.frontend.homiandroidfrontend.Response.PastureTimesResponse;
import homi.frontend.homiandroidfrontend.Response.PregnancyCheckupResponse;
import homi.frontend.homiandroidfrontend.Response.RutCheckResponse;
import homi.frontend.homiandroidfrontend.Response.StableNumberResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCaller
{
    private ApiInterface _getApi;
    private static ApiCaller _retrofitCaller = null;

    private ApiCaller() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.33.156.22/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        _getApi = retrofit.create(ApiInterface.class);
    }

    public Call<AnimalSimpleResponse> animalsSimple()
    {
        Call<AnimalSimpleResponse> animalsSimple = _getApi.animalsSimpleCall();
        return animalsSimple;
    }
    public Call<AnimalNotesResponse> animalNotesCall()
    {
        Call<AnimalNotesResponse> notes = _getApi.AnimalNoteCall();
        return notes;
    }

    public Call<CompleteSingleAnimalResponse> animalCompleteModels(int id)
    {
        Call<CompleteSingleAnimalResponse> animalCompleteModels = _getApi.CompleteSingleAnimalCall(id);
        return animalCompleteModels;
    }

    public Call<MatingResponse> matingResponseCall()
    {
        Call<MatingResponse> mating = _getApi.MatingsCall();
        return mating;
    }

    public Call<OrderGroupsResponse> orderGroupsResponseCall()
    {
        Call<OrderGroupsResponse> orderGroups = _getApi.OrderGroupsCall();
        return orderGroups;
    }
    public Call<PastureGroupConnectorResponse> pastureGroupConnectorResponseCall()
    {
        Call<PastureGroupConnectorResponse> pastureGroupConnectors = _getApi.PastureGroupConnectorCall();
        return pastureGroupConnectors;
    }
    public Call<PastureGroupResponse> pastureGroupResponseCall()
    {
        Call<PastureGroupResponse> pastureGroups = _getApi.PastureGroupsGroupCall();
        return pastureGroups;
    }
    public Call<PastureResponse> pastureResponseCall()
    {
        Call<PastureResponse> pastures = _getApi.PasturesCall();
        return pastures;
    }
    public Call<PastureTimesResponse> pastureTimesResponseCall()
    {
        Call<PastureTimesResponse> pastureTimes = _getApi.PastureTimesCall();
        return pastureTimes;
    }
    public Call<PregnancyCheckupResponse> pregnancyCheckupResponseCall()
    {
        Call<PregnancyCheckupResponse> pregnancyCheckups = _getApi.PregnancyCheckupCall();
        return pregnancyCheckups;
    }
    public Call<RutCheckResponse> rutCheckResponseCall()
    {
        Call<RutCheckResponse> rutChecks = _getApi.RutCheckCall();
        return rutChecks;
    }
    public Call<StableNumberResponse> stableNumberResponseCall()
    {
        Call<StableNumberResponse> stableNumbers = _getApi.StableNumberCall();
        return stableNumbers;
    }

    public static synchronized ApiCaller getInstance()
    {
        if(_retrofitCaller == null)
        {
            _retrofitCaller = new ApiCaller();
        }
        return _retrofitCaller;
    }
    public ApiInterface ApiConnection()
    {
        return _getApi;
    }
}
