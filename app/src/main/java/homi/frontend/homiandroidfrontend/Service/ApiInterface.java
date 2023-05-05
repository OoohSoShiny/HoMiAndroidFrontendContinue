package homi.frontend.homiandroidfrontend.Service;

import homi.frontend.homiandroidfrontend.Models.AnimalNotesModel;
import homi.frontend.homiandroidfrontend.Models.AnimalSimpleModel;
import homi.frontend.homiandroidfrontend.Models.CompleteSingleAnimalModel;
import homi.frontend.homiandroidfrontend.Models.MatingModel;
import homi.frontend.homiandroidfrontend.Models.OrderGroupsModel;
import homi.frontend.homiandroidfrontend.Models.PastureGroupConnectorModel;
import homi.frontend.homiandroidfrontend.Models.PastureGroupModel;
import homi.frontend.homiandroidfrontend.Models.PastureModel;
import homi.frontend.homiandroidfrontend.Models.PastureTimesModel;
import homi.frontend.homiandroidfrontend.Models.PregnancyCheckupModel;
import homi.frontend.homiandroidfrontend.Models.RutCheckModel;
import homi.frontend.homiandroidfrontend.Models.StableNumberModel;
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
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface
{
    @Headers({"Accept: application/json"})
    @GET("/api/Animals")
    Call<AnimalSimpleResponse> animalsSimpleCall();
    @POST("api/Animals")
    Call<AnimalSimpleModel> AnimalCreate(@Body AnimalSimpleModel animalModel);
    @PUT("api/Animals/{Id}")
    Call<AnimalSimpleModel> AnimalUpdate(@Path("Id") int id, @Body AnimalSimpleModel animalModel);
    @DELETE("api/Animals/{Id}")
    Call<Void> AnimalDelete(@Path("Id") int id);
    @GET("/api/Animals/{Id}")
    Call<CompleteSingleAnimalResponse> CompleteSingleAnimalCall(@Path("Id") int id);


    @GET("/api/AnimalNotes")
    Call<AnimalNotesResponse> AnimalNoteCall();
    @POST("api/AnimalNotes")
    Call<AnimalNotesModel> AnimalNotesCreate(@Body AnimalNotesModel animalNotesModel);
    @PUT("api/AnimalNotes/{Id}")
    Call<AnimalNotesModel> AnimalNotesUpdate(@Path("Id") int id, @Body AnimalNotesModel animalNotesModel);
    @DELETE("api/AnimalNotes/{Id}")
    Call<Void> AnimalNotesDelete(@Path("Id") int id);

    @GET("api/Mating")
    Call<MatingResponse> MatingsCall();
    @POST("api/Mating")
    Call<MatingModel> MatingCreate(@Body MatingModel matingModel);
    @PUT("api/Mating/{Id}")
    Call<MatingModel> MatingUpdate(@Path("Id") int id, @Body MatingModel matingModel);
    @DELETE("api/Mating/{Id}")
    Call<Void> MatingDelete(@Path("Id") int id);

    @GET("api/OrderGroups")
    Call<OrderGroupsResponse> OrderGroupsCall();
    @POST("api/OrderGroups")
    Call<OrderGroupsModel> OrderGroupCreate(@Body OrderGroupsModel orderGroupsModel);
    @PUT("api/OrderGroups/{Id}")
    Call<OrderGroupsModel> OrderGroupUpdateUpdate(@Path("Id") int id, @Body OrderGroupsModel orderGroupsModel);
    @DELETE("api/OrderGroups/{Id}")
    Call<Void> OrderGroupDelete(@Path("Id") int id);

    @GET("api/Pasture")
    Call<PastureResponse> PasturesCall();
    @POST("api/Pasture")
    Call<PastureModel> PasturesCreate(@Body PastureModel pastureModel);
    @PUT("api/Pasture/{Id}")
    Call<PastureModel> PasturesUpdate(@Path("Id") int id, @Body PastureModel pastureModel);
    @DELETE("api/Pasture/{Id}")
    Call<Void> PasturesDelete(@Path("Id") int id);

    @GET("api/PastureGroupConnectorModels")
    Call<PastureGroupConnectorResponse> PastureGroupConnectorCall();
    @POST("api/PastureGroupConnectorModels")
    Call<PastureGroupConnectorModel> PastureGroupConnectorCreate(@Body PastureGroupConnectorModel pastureGroupConnectorModel);
    @PUT("api/PastureGroupConnectorModels/{Id}")
    Call<PastureGroupConnectorModel> PastureGroupConnectorUpdate(@Path("Id") int id, @Body PastureGroupConnectorModel pastureGroupConnectorModel);
    @DELETE("api/PastureGroupConnectorModels/{Id}")
    Call<Void> PastureGroupConnectorDelete(@Path("Id") int id);

    @GET("api/PastureGroups")
    Call<PastureGroupResponse> PastureGroupsGroupCall();
    @POST("api/PastureGroups")
    Call<PastureGroupModel> PastureGroupsCreate(@Body PastureGroupModel pastureGroupModel);
    @PUT("api/PastureGroups/{Id}")
    Call<PastureGroupModel> PastureGroupsUpdate(@Path("Id") int id, @Body PastureGroupModel pastureGroupModel);
    @DELETE("api/PastureGroups/{Id}")
    Call<Void> PastureGroupsDelete(@Path("Id") int id);

    @GET("api/PregnancyCheckups")
    Call<PregnancyCheckupResponse> PregnancyCheckupCall();
    @POST("api/PregnancyCheckups")
    Call<PregnancyCheckupModel> PregnancyCheckupsCreate(@Body PregnancyCheckupModel animalModel);
    @PUT("api/PregnancyCheckups/{Id}")
    Call<PregnancyCheckupModel> PregnancyCheckupsUpdate(@Path("Id") int id, @Body PregnancyCheckupModel animalModel);
    @DELETE("api/PregnancyCheckups/{Id}")
    Call<Void> PregnancyCheckupsDelete(@Path("Id") int id);

    @GET("api/RutChecks")
    Call<RutCheckResponse> RutCheckCall();
    @POST("api/RutChecks")
    Call<RutCheckModel> RutChecksCreate(@Body RutCheckModel rutCheckModel);
    @PUT("api/RutChecks/{Id}")
    Call<RutCheckModel> RutChecksUpdate(@Path("Id") int id, @Body RutCheckModel rutCheckModel);
    @DELETE("api/RutChecks/{Id}")
    Call<Void> RutChecksDelete(@Path("Id") int id);

    @GET("api/StableNumbers")
    Call<StableNumberResponse> StableNumberCall();
    @POST("api/StableNumbers")
    Call<StableNumberModel> StableNumbersCreate(@Body StableNumberModel animalModel);
    @PUT("api/StableNumbers/{Id}")
    Call<StableNumberModel> StableNumbersUpdate(@Path("Id") int id, @Body StableNumberModel animalModel);
    @DELETE("api/StableNumbers/{Id}")
    Call<Void> StableNumbersDelete(@Path("Id") int id);

    @GET("api/StableNumbers")
    Call<PastureTimesResponse> PastureTimesCall();
    @POST("api/StableNumbers")
    Call<PastureTimesModel> PastureTimesCreate(@Body PastureTimesModel animalModel);
    @PUT("api/StableNumbers/{Id}")
    Call<PastureTimesModel> PastureTimesUpdate(@Path("Id") int id, @Body PastureTimesModel animalModel);
    @DELETE("api/StableNumbers/{Id}")
    Call<Void> PastureTimesDelete(@Path("Id") int id);
}
