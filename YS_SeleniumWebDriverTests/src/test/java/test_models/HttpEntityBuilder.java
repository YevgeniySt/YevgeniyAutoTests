package test_models;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/**
 * Created by Евгений on 01.11.2015.
 */
public class HttpEntityBuilder {

    public static HttpEntity createHttpEntityForPostCreatePlayer(PlayerFull playerFull){

        HttpEntity httpEntity = MultipartEntityBuilder.create()
                .addTextBody("#requestSender", playerFull.requestSender)
                .addTextBody("submitMode", "save")
                .addTextBody("ff14642ac1c__us_login", playerFull.login)
                .addTextBody("ff14642ac1c__us_email", playerFull.email)
                .addTextBody("ff14642ac1c__us_password", playerFull.password)
                .addTextBody("ff14642ac1c__confirm_password", playerFull.password)
                .addTextBody("ff14642ac1c__us_reg_status", playerFull.regStatus)
                .addTextBody("ff14642ac1c__us_chat_enabled", "0")
                .addTextBody("ff14642ac1c__us_chat_enabled", playerFull.chatEnabled)
                .addTextBody("ff14642ac1c__is_community", playerFull.isCommunity)
                .addTextBody("ff14642ac1c__us_owner_id", playerFull.ownerID)
                .addTextBody("ff14642ac1c__us_fname", playerFull.fName)
                .addTextBody("ff14642ac1c__us_lname", playerFull.lName)
                .addTextBody("ff14642ac1c__us_city", playerFull.city)
                .addTextBody("ff14642ac1c__us_country", playerFull.country)
                .addTextBody("ff14642ac1c__us_address", playerFull.address)
                .addTextBody("ff14642ac1c__us_phone", playerFull.phone)
                .addTextBody("ff14642ac1c__us_gender", playerFull.gender)
                .addTextBody("ff14642ac1c__us_birthday", playerFull.birthday)
                .addTextBody("ff14642ac1c__disable_lp", playerFull.disableLp)
                .addTextBody("ff14642ac1c__payment_chat_enabled", playerFull.chatEnabled)
                .addTextBody("ff14642ac1c__pit_boss_alert_enabled", playerFull.pittBossAlertEnabled)
                .addTextBody("ff14642ac1c__credit_type", playerFull.creditType)
                .addTextBody("ff14642ac1c__credit_amount", playerFull.creditAmount)
                .addTextBody("ff14642ac1c__credit_frequency", playerFull.creditFrequency)
                .addTextBody("ff14642ac1c__credit_next_reset", playerFull.creditNextReset)
                .addTextBody("ff14642ac1c__credit_temp", playerFull.creditTemp)
                .addTextBody("ff14642ac1c__credit_expiration", playerFull.creditExpiration)
                .addTextBody("ff14642ac1c__credit_comment", playerFull.creditComment)
                .addTextBody("ff14642ac1c__stop_weekly_reset", playerFull.stopWeeklyReset).build();
        return httpEntity;
    }
    public static HttpEntity createHttpEntityForPostSearchPlayer(PlayerFull playerFull){
        HttpEntity httpEntity = MultipartEntityBuilder.create()
                .addTextBody("723a925886__agent", "_unset_")
                .addTextBody("723a925886__city", "")
                .addTextBody("723a925886__email", "")
                .addTextBody("723a925886__external_ip_address", "")
                .addTextBody("723a925886__firstname", "")
                .addTextBody("723a925886__last_login", "")
                .addTextBody("723a925886__lastname", "")
                .addTextBody("723a925886__mac_address", "")
                .addTextBody("723a925886__null1", "")
                .addTextBody("723a925886__reg_date_from", "")
                .addTextBody("723a925886__reg_date_to", "")
                .addTextBody("723a925886__country", "_unset_")
                .addTextBody("723a925886__deleted", "0")
                .addTextBody("723a925886__is_community", "_unset_")
                .addTextBody("723a925886__login", playerFull.login)
                .addTextBody("723a925886__real_amount", "_unset_")
                .addTextBody("723a925886__state_type", "_unset_")
                .addTextBody("723a925886__vip_level", "_unset_")
                .addTextBody("filterpanel_submited_723a925886", "submited").build();
        return httpEntity;

    }
}
