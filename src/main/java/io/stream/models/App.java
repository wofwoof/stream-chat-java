package io.stream.models;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.stream.exceptions.StreamException;
import io.stream.models.App.AppUpdateRequestData.AppUpdateRequest;
import io.stream.models.ChannelType.ChannelTypeWithStringCommands;
import io.stream.models.framework.StreamResponseObject;
import io.stream.services.AppService;
import io.stream.services.framework.StreamServiceGenerator;
import io.stream.services.framework.StreamServiceHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class App extends StreamResponseObject {
  public App() {}

  @Nullable
  @JsonProperty("app")
  private AppConfig app;

  @Data
  public static final class APNConfig {
    public APNConfig() {}

    @NotNull
    @JsonProperty("enabled")
    private Boolean enabled;

    @NotNull
    @JsonProperty("development")
    private Boolean development;

    @Nullable
    @JsonProperty("auth_type")
    private String authType;

    @Nullable
    @JsonProperty("auth_key")
    private byte[] authKey;

    @NotNull
    @JsonProperty("notification_template")
    private String notificationTemplate;

    @Nullable
    @JsonProperty("host")
    private String host;

    @Nullable
    @JsonProperty("bundle_Id")
    private String bundleId;

    @Nullable
    @JsonProperty("team_Id")
    private String teamId;

    @Nullable
    @JsonProperty("key_Id")
    private String keyId;
  }

  @Data
  public static final class FirebaseConfig {
    public FirebaseConfig() {}

    @NotNull
    @JsonProperty("enabled")
    private Boolean enabled;

    @NotNull
    @JsonProperty("notification_template")
    private String notificationTemplate;

    @NotNull
    @JsonProperty("data_template")
    private String dataTemplate;
  }

  @Data
  public static final class PushNotificationFields {
    public PushNotificationFields() {}

    @NotNull private String version;

    @NotNull
    @JsonProperty("apn")
    private APNConfig aPNConfig;

    @NotNull
    @JsonProperty("firebase")
    private FirebaseConfig firebaseConfig;
  }

  @Data
  public static final class Policy {
    public Policy() {}

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("resources")
    private List<String> resources;

    @NotNull
    @JsonProperty("roles")
    private List<String> roles;

    @NotNull
    @JsonProperty("action")
    private Integer action;

    @NotNull
    @JsonProperty("owner")
    private Boolean owner;

    @NotNull
    @JsonProperty("priority")
    private Integer priority;

    @NotNull
    @JsonProperty("created_at")
    private Date createdAt;

    @NotNull
    @JsonProperty("updated_at")
    private Date updatedAt;
  }

  @Data
  public static final class AppConfig {
    public AppConfig() {}

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("organization")
    private String organizationName;

    @NotNull
    @JsonProperty("webhook_url")
    private String webhookURL;

    @NotNull
    @JsonProperty("suspended_explanation")
    private String suspendedExplanation;

    @NotNull
    @JsonProperty("push_notifications")
    private PushNotificationFields pushNotifications;

    @NotNull
    @JsonProperty("channel_configs")
    private Map<String, ChannelTypeWithStringCommands> channelConfigs;

    @NotNull
    @JsonProperty("policies")
    private Map<String, Policy[]> policies;

    @NotNull
    @JsonProperty("suspended")
    private Boolean suspended;

    @NotNull
    @JsonProperty("disable_auth_checks")
    private Boolean disableAuth;

    @NotNull
    @JsonProperty("disable_permissions_checks")
    private Boolean disablePermissions;

    @NotNull
    @JsonProperty("multi_tenant_enabled")
    private Boolean multiTenantEnabled;

    @NotNull
    @JsonProperty("permission_version")
    private String permissionVersion;

    @Nullable
    @JsonProperty("user_search_disallowed_roles")
    private List<String> userSearchDisallowedRoles;

    @NotNull
    @JsonProperty("image_moderation_enabled")
    private Boolean imageModerationEnabled;

    @Nullable
    @JsonProperty("image_moderation_labels")
    private List<String> imageModerationLabels;

    @Nullable
    @JsonProperty("custom_action_handler_url")
    private String customActionHandlerUrl;

    @Nullable
    @JsonProperty("enforce_unique_usernames")
    private String enforceUniqueUsernames;

    @Nullable
    @JsonProperty("sqs_url")
    private String sqsUrl;

    @Nullable
    @JsonProperty("sqs_key")
    private String sqsKey;

    @Nullable
    @JsonProperty("sqs_secret")
    private String sqsSecret;

    @Nullable
    @JsonProperty("file_upload_config")
    private FileUploadConfig fileUploadConfig;

    @Nullable
    @JsonProperty("image_upload_config")
    private FileUploadConfig imageUploadConfig;

    @Nullable
    @JsonProperty("before_message_send_hook_url")
    private String beforeMessageSendHookUrl;

    @Nullable
    @JsonProperty("auto_translation_enabled")
    private Boolean autoTranslationEnabled;
  }

  @Data
  public static final class FileUploadConfig {
    public FileUploadConfig() {}

    @Nullable
    @JsonProperty("allowed_file_extensions")
    private List<String> allowedFileExtensions;

    @Nullable
    @JsonProperty("blocked_file_extensions")
    private List<String> blockedFileExtensions;

    @Nullable
    @JsonProperty("allowed_mime_types")
    private List<String> allowedMimeTypes;

    @Nullable
    @JsonProperty("blocked_mime_types")
    private List<String> blockedMimeTypes;
  }

  @Data
  public static final class AppUpdateRequestData {
    public AppUpdateRequestData() {}

    @Nullable
    @JsonProperty("disable_auth_checks")
    private Boolean disableAuth;

    @Nullable
    @JsonProperty("disable_permissions_checks")
    private Boolean disablePermissions;

    @Nullable
    @JsonProperty("apn_config")
    private APNConfigRequest aPNConfig;

    @Nullable
    @JsonProperty("firebase_config")
    private FirebaseConfigRequest firebaseConfig;

    @Nullable
    @JsonProperty("push_config")
    private PushConfigRequest pushConfig;

    @Nullable
    @JsonProperty("user_search_disallowed_roles")
    private List<String> userSearchDisallowedRoles;

    @Nullable
    @JsonProperty("custom_action_handler_url")
    private String customActionHandlerUrl;

    @Nullable
    @JsonProperty("enforce_unique_usernames")
    private String enforceUniqueUsernames;

    @NotNull
    @JsonProperty("permission_version")
    private String permissionVersion;

    @Nullable
    @JsonProperty("file_upload_config")
    private FileUploadConfigRequest fileUploadConfig;

    @Nullable
    @JsonProperty("image_upload_config")
    private FileUploadConfigRequest imageUploadConfig;

    @Nullable
    @JsonProperty("before_message_send_hook_url")
    private String beforeMessageSendHookUrl;

    @Nullable
    @JsonProperty("auto_translation_enabled")
    private Boolean autoTranslationEnabled;

    @NotNull
    @JsonProperty("image_moderation_enabled")
    private Boolean imageModerationEnabled;

    @Nullable
    @JsonProperty("image_moderation_labels")
    private List<String> imageModerationLabels;

    @Nullable
    @JsonProperty("sqs_url")
    private String sqsUrl;

    @Nullable
    @JsonProperty("sqs_key")
    private String sqsKey;

    @Nullable
    @JsonProperty("sqs_secret")
    private String sqsSecret;

    @Nullable
    @JsonProperty("webhook_url")
    private String webhookURL;

    @Nullable
    @JsonProperty("multi_tenant_enabled")
    private Boolean multiTenantEnabled;

    private AppUpdateRequestData(AppUpdateRequest builder) {
      this.disableAuth = builder.disableAuth;
      this.disablePermissions = builder.disablePermissions;
      this.aPNConfig = builder.aPNConfig;
      this.firebaseConfig = builder.firebaseConfig;
      this.pushConfig = builder.pushConfig;
      this.userSearchDisallowedRoles = builder.userSearchDisallowedRoles;
      this.customActionHandlerUrl = builder.customActionHandlerUrl;
      this.enforceUniqueUsernames = builder.enforceUniqueUsernames;
      this.permissionVersion = builder.permissionVersion;
      this.fileUploadConfig = builder.fileUploadConfig;
      this.imageUploadConfig = builder.imageUploadConfig;
      this.beforeMessageSendHookUrl = builder.beforeMessageSendHookUrl;
      this.autoTranslationEnabled = builder.autoTranslationEnabled;
      this.imageModerationEnabled = builder.imageModerationEnabled;
      this.imageModerationLabels = builder.imageModerationLabels;
      this.sqsUrl = builder.sqsUrl;
      this.sqsKey = builder.sqsKey;
      this.sqsSecret = builder.sqsSecret;
      this.webhookURL = builder.webhookURL;
      this.multiTenantEnabled = builder.multiTenantEnabled;
    }

    public static final class AppUpdateRequest {
      private Boolean disableAuth;
      private Boolean disablePermissions;
      private APNConfigRequest aPNConfig;
      private FirebaseConfigRequest firebaseConfig;
      private PushConfigRequest pushConfig;
      private List<String> userSearchDisallowedRoles = Collections.emptyList();
      private String customActionHandlerUrl;
      private String enforceUniqueUsernames;
      private String permissionVersion;
      private FileUploadConfigRequest fileUploadConfig;
      private FileUploadConfigRequest imageUploadConfig;
      private String beforeMessageSendHookUrl;
      private Boolean autoTranslationEnabled;
      private Boolean imageModerationEnabled;
      private List<String> imageModerationLabels = Collections.emptyList();
      private String sqsUrl;
      private String sqsKey;
      private String sqsSecret;
      private String webhookURL;
      private Boolean multiTenantEnabled;

      private AppUpdateRequest() {}

      @NotNull
      public AppUpdateRequest withDisableAuth(@NotNull Boolean disableAuth) {
        this.disableAuth = disableAuth;
        return this;
      }

      @NotNull
      public AppUpdateRequest withDisablePermissions(@NotNull Boolean disablePermissions) {
        this.disablePermissions = disablePermissions;
        return this;
      }

      @NotNull
      public AppUpdateRequest withAPNConfig(@NotNull APNConfigRequest aPNConfig) {
        this.aPNConfig = aPNConfig;
        return this;
      }

      @NotNull
      public AppUpdateRequest withFirebaseConfig(@NotNull FirebaseConfigRequest firebaseConfig) {
        this.firebaseConfig = firebaseConfig;
        return this;
      }

      @NotNull
      public AppUpdateRequest withPushConfig(@NotNull PushConfigRequest pushConfig) {
        this.pushConfig = pushConfig;
        return this;
      }

      @NotNull
      public AppUpdateRequest withUserSearchDisallowedRoles(
          @NotNull List<String> userSearchDisallowedRoles) {
        this.userSearchDisallowedRoles = userSearchDisallowedRoles;
        return this;
      }

      @NotNull
      public AppUpdateRequest withCustomActionHandlerUrl(@NotNull String customActionHandlerUrl) {
        this.customActionHandlerUrl = customActionHandlerUrl;
        return this;
      }

      @NotNull
      public AppUpdateRequest withEnforceUniqueUsernames(@NotNull String enforceUniqueUsernames) {
        this.enforceUniqueUsernames = enforceUniqueUsernames;
        return this;
      }

      @NotNull
      public AppUpdateRequest withPermissionVersion(@NotNull String permissionVersion) {
        this.permissionVersion = permissionVersion;
        return this;
      }

      @NotNull
      public AppUpdateRequest withFileUploadConfig(
          @NotNull FileUploadConfigRequest fileUploadConfig) {
        this.fileUploadConfig = fileUploadConfig;
        return this;
      }

      @NotNull
      public AppUpdateRequest withImageUploadConfig(
          @NotNull FileUploadConfigRequest imageUploadConfig) {
        this.imageUploadConfig = imageUploadConfig;
        return this;
      }

      @NotNull
      public AppUpdateRequest withBeforeMessageSendHookUrl(
          @NotNull String beforeMessageSendHookUrl) {
        this.beforeMessageSendHookUrl = beforeMessageSendHookUrl;
        return this;
      }

      @NotNull
      public AppUpdateRequest withAutoTranslationEnabled(@NotNull Boolean autoTranslationEnabled) {
        this.autoTranslationEnabled = autoTranslationEnabled;
        return this;
      }

      @NotNull
      public AppUpdateRequest withImageModerationEnabled(@NotNull Boolean imageModerationEnabled) {
        this.imageModerationEnabled = imageModerationEnabled;
        return this;
      }

      @NotNull
      public AppUpdateRequest withImageModerationLabels(
          @NotNull List<String> imageModerationLabels) {
        this.imageModerationLabels = imageModerationLabels;
        return this;
      }

      @NotNull
      public AppUpdateRequest withSqsUrl(@NotNull String sqsUrl) {
        this.sqsUrl = sqsUrl;
        return this;
      }

      @NotNull
      public AppUpdateRequest withSqsKey(@NotNull String sqsKey) {
        this.sqsKey = sqsKey;
        return this;
      }

      @NotNull
      public AppUpdateRequest withSqsSecret(@NotNull String sqsSecret) {
        this.sqsSecret = sqsSecret;
        return this;
      }

      @NotNull
      public AppUpdateRequest withWebhookURL(@NotNull String webhookURL) {
        this.webhookURL = webhookURL;
        return this;
      }

      @NotNull
      public AppUpdateRequest withMultiTenantEnabled(@NotNull Boolean multiTenantEnabled) {
        this.multiTenantEnabled = multiTenantEnabled;
        return this;
      }

      @NotNull
      /**
       * Executes the request
       *
       * @return the rate limit information
       * @throws StreamException when IO problem occurs or the stream API return an error
       */
      public StreamResponseObject request() throws StreamException {
        return new StreamServiceHandler()
            .handle(
                StreamServiceGenerator.createService(AppService.class)
                    .update(new AppUpdateRequestData(this)));
      }
    }
  }

  @Data
  public static final class FileUploadConfigRequest {
    public FileUploadConfigRequest() {}

    @Nullable
    @JsonProperty("allowed_file_extensions")
    private List<String> allowedFileExtensions;

    @Nullable
    @JsonProperty("blocked_file_extensions")
    private List<String> blockedFileExtensions;

    @Nullable
    @JsonProperty("allowed_mime_types")
    private List<String> allowedMimeTypes;

    @Nullable
    @JsonProperty("blocked_mime_types")
    private List<String> blockedMimeTypes;

    private FileUploadConfigRequest(Builder builder) {
      this.allowedFileExtensions = builder.allowedFileExtensions;
      this.blockedFileExtensions = builder.blockedFileExtensions;
      this.allowedMimeTypes = builder.allowedMimeTypes;
      this.blockedMimeTypes = builder.blockedMimeTypes;
    }

    /**
     * Creates builder to build {@link FileUploadConfigRequest}.
     *
     * @return created builder
     */
    public static Builder builder() {
      return new Builder();
    }

    /** Builder to build {@link FileUploadConfigRequest}. */
    public static final class Builder {
      private List<String> allowedFileExtensions = Collections.emptyList();
      private List<String> blockedFileExtensions = Collections.emptyList();
      private List<String> allowedMimeTypes = Collections.emptyList();
      private List<String> blockedMimeTypes = Collections.emptyList();

      private Builder() {}

      @NotNull
      public Builder withAllowedFileExtensions(@NotNull List<String> allowedFileExtensions) {
        this.allowedFileExtensions = allowedFileExtensions;
        return this;
      }

      @NotNull
      public Builder withBlockedFileExtensions(@NotNull List<String> blockedFileExtensions) {
        this.blockedFileExtensions = blockedFileExtensions;
        return this;
      }

      @NotNull
      public Builder withAllowedMimeTypes(@NotNull List<String> allowedMimeTypes) {
        this.allowedMimeTypes = allowedMimeTypes;
        return this;
      }

      @NotNull
      public Builder withBlockedMimeTypes(@NotNull List<String> blockedMimeTypes) {
        this.blockedMimeTypes = blockedMimeTypes;
        return this;
      }

      @NotNull
      public FileUploadConfigRequest build() {
        return new FileUploadConfigRequest(this);
      }
    }
  }

  @Data
  public static final class APNConfigRequest {
    public APNConfigRequest() {}

    @NotNull
    @JsonProperty("enabled")
    private Boolean enabled;

    @NotNull
    @JsonProperty("development")
    private Boolean development;

    @Nullable
    @JsonProperty("auth_type")
    private String authType;

    @Nullable
    @JsonProperty("auth_key")
    private byte[] authKey;

    @NotNull
    @JsonProperty("notification_template")
    private String notificationTemplate;

    @Nullable
    @JsonProperty("host")
    private String host;

    @Nullable
    @JsonProperty("bundle_Id")
    private String bundleId;

    @Nullable
    @JsonProperty("team_Id")
    private String teamId;

    @Nullable
    @JsonProperty("key_Id")
    private String keyId;

    private APNConfigRequest(Builder builder) {
      this.enabled = builder.enabled;
      this.development = builder.development;
      this.authType = builder.authType;
      this.authKey = builder.authKey;
      this.notificationTemplate = builder.notificationTemplate;
      this.host = builder.host;
      this.bundleId = builder.bundleId;
      this.teamId = builder.teamId;
      this.keyId = builder.keyId;
    }

    /**
     * Creates builder to build {@link APNConfigRequest}.
     *
     * @return created builder
     */
    public static Builder builder() {
      return new Builder();
    }

    /** Builder to build {@link APNConfigRequest}. */
    public static final class Builder {
      private Boolean enabled;
      private Boolean development;
      private String authType;
      private byte[] authKey;
      private String notificationTemplate;
      private String host;
      private String bundleId;
      private String teamId;
      private String keyId;

      private Builder() {}

      @NotNull
      public Builder withEnabled(@NotNull Boolean enabled) {
        this.enabled = enabled;
        return this;
      }

      @NotNull
      public Builder withDevelopment(@NotNull Boolean development) {
        this.development = development;
        return this;
      }

      @NotNull
      public Builder withAuthType(@NotNull String authType) {
        this.authType = authType;
        return this;
      }

      @NotNull
      public Builder withAuthKey(@NotNull byte[] authKey) {
        this.authKey = authKey;
        return this;
      }

      @NotNull
      public Builder withNotificationTemplate(@NotNull String notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
        return this;
      }

      @NotNull
      public Builder withHost(@NotNull String host) {
        this.host = host;
        return this;
      }

      @NotNull
      public Builder withBundleId(@NotNull String bundleId) {
        this.bundleId = bundleId;
        return this;
      }

      @NotNull
      public Builder withTeamId(@NotNull String teamId) {
        this.teamId = teamId;
        return this;
      }

      @NotNull
      public Builder withKeyId(@NotNull String keyId) {
        this.keyId = keyId;
        return this;
      }

      @NotNull
      public APNConfigRequest build() {
        return new APNConfigRequest(this);
      }
    }
  }

  @Data
  public static final class FirebaseConfigRequest {
    public FirebaseConfigRequest() {}

    @NotNull
    @JsonProperty("enabled")
    private Boolean enabled;

    @NotNull
    @JsonProperty("notification_template")
    private String notificationTemplate;

    @NotNull
    @JsonProperty("data_template")
    private String dataTemplate;

    private FirebaseConfigRequest(Builder builder) {
      this.enabled = builder.enabled;
      this.notificationTemplate = builder.notificationTemplate;
      this.dataTemplate = builder.dataTemplate;
    }

    /**
     * Creates builder to build {@link FirebaseConfigRequest}.
     *
     * @return created builder
     */
    public static Builder builder() {
      return new Builder();
    }

    /** Builder to build {@link FirebaseConfigRequest}. */
    public static final class Builder {
      private Boolean enabled;
      private String notificationTemplate;
      private String dataTemplate;

      private Builder() {}

      @NotNull
      public Builder withEnabled(@NotNull Boolean enabled) {
        this.enabled = enabled;
        return this;
      }

      @NotNull
      public Builder withNotificationTemplate(@NotNull String notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
        return this;
      }

      @NotNull
      public Builder withDataTemplate(@NotNull String dataTemplate) {
        this.dataTemplate = dataTemplate;
        return this;
      }

      @NotNull
      public FirebaseConfigRequest build() {
        return new FirebaseConfigRequest(this);
      }
    }
  }

  public static class PushConfigRequest {
    public PushConfigRequest() {}

    @Nullable
    @JsonProperty("version")
    private String version;
  }

  /**
   * Retrieves the app.
   *
   * @return the retrieved app
   * @throws StreamException when IO problem occurs or the stream API return an error
   */
  public static App get() throws StreamException {
    return new StreamServiceHandler()
        .handle(StreamServiceGenerator.createService(AppService.class).get());
  }

  /**
   * Creates an update request.
   *
   * @return the created request
   */
  public static final AppUpdateRequest update() {
    return new AppUpdateRequest();
  }
}
