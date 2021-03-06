package com.Grupo6.CadeMeuPet.security;

public class SecurityConstants {
    public static final String SIGN_UP_URL = "/api/user/record";
    public static final String LOST_PETS_URL = "/api/pet/list/search/lostpets";
    public static final String FOUND_PETS_URL = "/api/pet/list/search/foundpets";
    public static final String ALL_PETS_URL = "api/pet/list/";
    public static final String[] AUTH_LIST = {
            // -- swagger ui
            "**/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/api/**"
    };
    public static final String KEY= "q3t6w9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSgUkXp2s5v8y/B?E(H+MbQeTh";
    public static final String HEADER_NAME = "Authorization";
    public static final Long EXPIRATION_TIME = 1000L * 60 * 30;
}
