@Bean
public WebMvcConfigurer corsMappingConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            WebConfigProperties.Cors cors = webConfigProperties.getCors();
            registry.addMapping("/**")
            .allowedOrigins(cors.getAllowedOrigins())
            .allowedMethods(cors.getAllowedMethods())
            .maxAge(cors.getMaxAge())
            .allowedHeaders(cors.getAllowedHeaders())
            .exposedHeaders(cors.getExposedHeaders());
        }
    };
}