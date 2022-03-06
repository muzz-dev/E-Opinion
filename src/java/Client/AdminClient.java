/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:AdminResource [admin]<br>
 * USAGE:
 * <pre>
 *        AdminClient client = new AdminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author muzz
 */
public class AdminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/E-Opinion/webresources";

    public AdminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("admin");
    }

    public void InsertVillage(String Talukaid, String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertVillage/{0}/{1}/{2}", new Object[]{Talukaid, Name, isActive})).request().post(null);
    }

    public void UpdateZone(String zoneid, String name, String villageid) throws ClientErrorException {
        Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateZone/{0}/{1}/{2}", new Object[]{zoneid, name, villageid})).request().put(empty);
    }

    public void UpdateTalukaActive(String id, String Active) throws ClientErrorException {
         Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateTalukaActive/{0}/{1}", new Object[]{id, Active})).request().put(empty);
    }

    public String findzonename(String zid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findzonename/{0}", new Object[]{zid}));
        return resource.request().get(String.class);
    }

    public <T> T findAllZone(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllZone");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateZoneActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateZoneActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public void InsertOccupation(String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertOccupation/{0}/{1}", new Object[]{Name, isActive})).request().post(null);
    }

    public <T> T findStateByDistrictId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findStateByDistrictId/{0}", new Object[]{id}));
        return resource.request().get(responseType);
    }

    public String findDistrictbyVillage(String vid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findDistrictbyVillage/{0}", new Object[]{vid}));
        return resource.request().get(String.class);
    }

    public <T> T findDepartmentById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findDepartmentById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteOccupation(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteOccupation/{0}", new Object[]{Id})).request().delete();
    }

    public String findStateByTalukaid(String talukaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findStateByTalukaid/{0}", new Object[]{talukaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void DeleteTaluka(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteTaluka/{0}", new Object[]{Id})).request().delete();
    }

    public void DeleteQualification(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteQualification/{0}", new Object[]{Id})).request().delete();
    }

    public void DeleteZone(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteZone/{0}", new Object[]{Id})).request().delete();
    }

    public <T> T findalldepartment(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findalldepartment");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findAllVillage(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllVillage");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String findTalukabyVillageId(String vid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findTalukabyVillageId/{0}", new Object[]{vid}));
        return resource.request().get(String.class);
    }

    public void InsertWard(String zid, String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertWard/{0}/{1}/{2}", new Object[]{zid, Name, isActive})).request().post(null);
    }

    public void UpdateOccupation(String id, String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateOccupation/{0}/{1}", new Object[]{id, name})).request().put(null);
    }

    public void InsertTaluka(String DistrictId, String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertTaluka/{0}/{1}/{2}", new Object[]{DistrictId, Name, isActive})).request().post(null);
    }

    public void InsertState(String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertState/{0}/{1}", new Object[]{Name, isActive})).request().post(null);
    }

    public void UpdateOccupationActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateOccupationActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public void UpdateWard(String wardid, String name, String zoneid) throws ClientErrorException {
         Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateWard/{0}/{1}/{2}", new Object[]{wardid, name, zoneid})).request().put(empty);
    }

    public <T> T findAllOccupation(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllOccupation");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findByTalukaid(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findByTalukaid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findVillageById(Class<T> responseType, String vid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findVillageById/{0}", new Object[]{vid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findTalukaByDistrictId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findTalukaByDistrictId/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteQuestionType(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteQuestionType/{0}", new Object[]{Id})).request().delete();
    }

    public <T> T findAllTaluka(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllTaluka");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateTaluka(String id, String tname, String districtId) throws ClientErrorException {
         Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateTaluka/{0}/{1}/{2}", new Object[]{id, tname, districtId})).request().put(empty);
    }

    public <T> T findAllWard(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllWard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findAllQualification(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllQualification");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteVillage(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteVillage/{0}", new Object[]{Id})).request().delete();
    }

    public void DeleteQuestion(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteQuestion/{0}", new Object[]{Id})).request().delete();
    }

    public String findStateByVillage(String vid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findStateByVillage/{0}", new Object[]{vid}));
        return resource.request().get(String.class);
    }

    public <T> T findAllDistrict(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllDistrict");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String findDistrictByTalukaid(String talukaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findDistrictByTalukaid/{0}", new Object[]{talukaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void InsertDepartment(String deptName, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertDepartment/{0}/{1}", new Object[]{deptName, isActive})).request().post(null);
    }

    public void InsertQualification(String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertQualification/{0}/{1}", new Object[]{Name, isActive})).request().post(null);
    }

    public void UpdateDistrict(String id, String dname, String sid) throws ClientErrorException {
         Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateDistrict/{0}/{1}/{2}", new Object[]{id, dname, sid})).request().put(empty);
    }

    public void UpdateCastActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateCastActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public void InsertZone(String vid, String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertZone/{0}/{1}/{2}", new Object[]{vid, Name, isActive})).request().post(null);
    }

    public <T> T findAllQuestionType(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllQuestionType");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateQuestionType(String Id, String TypeName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateQuestionType/{0}/{1}", new Object[]{Id, TypeName})).request().put(null);
    }

    public String findByDistrictId(String districtid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findByDistrictId/{0}", new Object[]{districtid}));
        return resource.request().get(String.class);
    }

    public void DeleteDepartment(String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteDepartment/{0}", new Object[]{deptId})).request().delete();
    }

    public <T> T findZoneByVillageId(Class<T> responseType, String vid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findZoneByVillageId/{0}", new Object[]{vid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateVillageActive(String id, String Active) throws ClientErrorException {
         Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateVillageActive/{0}/{1}", new Object[]{id, Active})).request().put(empty);
    }

    public <T> T findStateById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findStateById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findByDistrictIdStateName(Class<T> responseType, String districtId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findByDistrictIdStateName/{0}", new Object[]{districtId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void InsertCast(String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertCast/{0}/{1}", new Object[]{Name, isActive})).request().post(null);
    }

    public void InsertDistrict(String Stateid, String Name, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertDistrict/{0}/{1}/{2}", new Object[]{Stateid, Name, isActive})).request().post(null);
    }

    public void DeleteDistrict(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteDistrict/{0}", new Object[]{Id})).request().delete();
    }

    public void UpdateDistrictActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateDistrictActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public void DeleteCast(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteCast/{0}", new Object[]{Id})).request().delete();
    }

    public void UpdateDepartmentActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateDepartmentActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public String findVillageByZoneid(String zid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findVillageByZoneid/{0}", new Object[]{zid}));
        return resource.request().get(String.class);
    }

    public void updateState(String Name, String stateid) throws ClientErrorException {
        Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("updateState/{0}/{1}", new Object[]{Name, stateid})).request().put(empty);
    }

    public void InsertQuestionType(String Type, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertQuestionType/{0}/{1}", new Object[]{Type, isActive})).request().post(null);
    }

    public void DeleteState(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteState/{0}", new Object[]{id})).request().delete();
    }

    public <T> T findAllUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findallFeedback(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallFeedback");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateVillage(String id, String name, String talukeId) throws ClientErrorException {
        Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateVillage/{0}/{1}/{2}", new Object[]{id, name, talukeId})).request().put(empty);
    }

    public void DeleteWard(String Id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteWard/{0}", new Object[]{Id})).request().delete();
    }

    public <T> T findAllCast(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllCast");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateQualification(String id, String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateQualification/{0}/{1}", new Object[]{id, name})).request().put(null);
    }

    public void UpdateQuestionTypeActive(String Id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateQuestionTypeActive/{0}/{1}", new Object[]{Id, Active})).request().put(null);
    }

    public <T> T findVillageByTalukaId(Class<T> responseType, String talukaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findVillageByTalukaId/{0}", new Object[]{talukaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateCast(String id, String name) throws ClientErrorException {
         Entity<?> empty = Entity.text(""); //new line added
        webTarget.path(java.text.MessageFormat.format("UpdateCast/{0}/{1}", new Object[]{id, name})).request().put(empty);
    }

    public void UpdateWardActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateWardActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public void updateDepartment(String deptName, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateDepartment/{0}/{1}", new Object[]{deptName, id})).request().put(null);
    }

    public void DeleteFeed(String Id, String n) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteFeed/{0}/{1}", new Object[]{Id, n})).request().delete();
    }

    public <T> T findAllQuestion(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllQuestion");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findAllState(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findAllState");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateQualificationActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateQualificationActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public void UpdateStateActive(String id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateStateActive/{0}/{1}", new Object[]{id, Active})).request().put(null);
    }

    public <T> T findallANSWER(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallANSWER");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateQuestionActive(String Id, String Active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateQuestionActive/{0}/{1}", new Object[]{Id, Active})).request().put(null);
    }

    public void close() {
        client.close();
    }
    
}
