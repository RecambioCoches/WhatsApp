package io.realm;


public interface com_pdg_WhatsApp_model_ChatsRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$nombreChat();
    public void realmSet$nombreChat(String value);
    public RealmList<com.pdg.WhatsApp.model.Mensaje> realmGet$mensajes();
    public void realmSet$mensajes(RealmList<com.pdg.WhatsApp.model.Mensaje> value);
    public RealmList<String> realmGet$nombreUsers();
    public void realmSet$nombreUsers(RealmList<String> value);
    public int realmGet$imagen();
    public void realmSet$imagen(int value);
}
