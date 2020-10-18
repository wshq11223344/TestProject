//package com.example.testpproject.internet;
//
//import com.google.gson.Gson;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import conversation.hazhi.han.application.dailytask.SubmitTask;
//import conversation.hazhi.han.application.dailytask.Task;
//import conversation.hazhi.han.application.login.User;
//
//public class NetworkApi {
//
//
//    public static final String BasicUrl = "http://192.168.2.165:8686";
//    public static final String RegisterUrl = BasicUrl + "/app/register";
//    public static final String LoginUrl = BasicUrl + "/app/login";
//    public static final String VerPhoneUrl = BasicUrl + "/app/getUserByPhone";
//    public static final String updateUrl = BasicUrl + "/app/updateUser";
//    public static final String TOKEN_URL = BasicUrl + "/config/getUpToken";
//    public static final String DELETE_URL = BasicUrl + "/config/delete";
//    public static final String GetUserByid = BasicUrl + "/app/getUserById";
//    public static final String AddUserTaskUrl = BasicUrl + "/task/addUserTask";
//    public static final String DeleteTaskUrl = BasicUrl + "/task/deleteTask";
//    public static final String GetTaskByUTUrl = BasicUrl + "/task/getTaskByUserIdAndType";
//    public static final String GetUserTaskNum = BasicUrl + "/task/getUserTaskNum";
//    public static final String UpdateTask = BasicUrl + "/task/updateTask";
//    public static final String ParentCheck = BasicUrl + "/app/parentsCheck";
//    public static final String GetDailyTask = BasicUrl + "/task/getUserDailyFinishTask";
//    public static final String FinishTask = BasicUrl + "/task/finishTask";
//
//
//    public static Gson mGson = new Gson();
//
//
//    public static void register(User user, NetworkManager.SuccessCallback<User> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//      /*  Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("account", user.getAccount());
//        paramsMap.put("password", user.getPassword());
//        paramsMap.put("phone", user.getPhone());
//        paramsMap.put("imeiid", user.getImeiid());*/
//
//
//        NetworkManager.getInstance().postResultClass(RegisterUrl, mGson.toJson(user), User.class, listener, failedCallback);
//
//
//    }
//
//
//    public static void verPhone(String phone, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("phone", phone);
//
//        NetworkManager.getInstance().getResultString(VerPhoneUrl, paramsMap, listener, failedCallback);
//
//
//    }
//
//    public static void getUserByid(String userId, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("id", userId);
//
//        NetworkManager.getInstance().getResultString(GetUserByid, paramsMap, listener, failedCallback);
//
//
//    }
//
//
//    public static void login(String userName, String password, NetworkManager.SuccessCallback<User> listener, NetworkManager.FailedCallback failedCallback) {
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("phone", userName);
//        paramsMap.put("password", password);
//
//        NetworkManager.getInstance().postResultClass(LoginUrl, paramsMap, User.class, listener, failedCallback);
//
//
//    }
//
//
//    public static void updateUserPasssWord(String id, String parameter, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        User user = new User(id, parameter);
//
//        NetworkManager.getInstance().postResultString(updateUrl, mGson.toJson(user), listener, failedCallback);
//
//    }
//
//
//    public static void updateUserAvator(String id, String avator, String phone, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        User user = new User(avator, id, phone);
//
//        NetworkManager.getInstance().postResultString(updateUrl, mGson.toJson(user), listener, failedCallback);
//
//    }
//
//
//    public static void get_token(NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//        Map<String, String> paramsMap = new HashMap<>();
//
//        NetworkManager.getInstance().getResultString(TOKEN_URL, paramsMap, listener, failedCallback);
//    }
//
//
//    public static void delete_key(String key, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("key", key);
//
//
//        NetworkManager.getInstance().postResultString(DELETE_URL, paramsMap, listener, failedCallback);
//
//
//    }
//
//
//    public static void addUserTask(Task task, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        NetworkManager.getInstance().postResultString(AddUserTaskUrl, mGson.toJson(task), listener, failedCallback);
//
//    }
//
//
//    public static void deleteTask(String userId, String taskId, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("userId", userId);
//        paramsMap.put("taskId", taskId);
//
//        NetworkManager.getInstance().postResultString(DeleteTaskUrl, paramsMap, listener, failedCallback);
//
//    }
//
//    public static void getTaskByUserIdAndType(String userId, String typeId, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("userId", userId);
//        paramsMap.put("typeId", typeId);
//
//        NetworkManager.getInstance().getResultString(GetTaskByUTUrl, paramsMap, listener, failedCallback);
//
//    }
//
//
//    public static void getUserTaskNum(String userId, String typeId, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("userId", userId);
//        paramsMap.put("typeId", typeId);
//
//        NetworkManager.getInstance().getResultString(GetUserTaskNum, paramsMap, listener, failedCallback);
//
//    }
//
//
//    public static void updateTask(Task task, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        NetworkManager.getInstance().postResultString(UpdateTask, mGson.toJson(task), listener, failedCallback);
//
//
//    }
//
//
//    public static void parentsCheck(String userId, String password, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("userId", userId);
//        paramsMap.put("password", password);
//
//        NetworkManager.getInstance().postResultString(ParentCheck, paramsMap, listener, failedCallback);
//
//    }
//
//
//    public static void getUserDailyFinishTask(String userId, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("userId", userId);
//
//        NetworkManager.getInstance().getResultString(GetDailyTask, paramsMap, listener, failedCallback);
//
//    }
//
//
//    public static void finishTask(SubmitTask submitTask, NetworkManager.SuccessCallback<String> listener, NetworkManager.FailedCallback failedCallback) {
//
//
//        NetworkManager.getInstance().postResultString(FinishTask, mGson.toJson(submitTask), listener, failedCallback);
//
//
//    }
//
//}
