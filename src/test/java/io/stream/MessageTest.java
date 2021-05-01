package io.stream;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.stream.models.App;
import io.stream.models.App.FileUploadConfigRequestObject;
import io.stream.models.Channel;
import io.stream.models.Message;
import io.stream.models.Message.Crop;
import io.stream.models.Message.ImageSizeRequestObject;
import io.stream.models.Message.MessageRequestObject;
import io.stream.models.Message.Resize;
import io.stream.models.Message.SearchResult;

public class MessageTest extends BasicTest {

  @DisplayName("Can send a message")
  @Test
  void whenSendingAMessage_thenNoException() {
    Channel channel = Assertions.assertDoesNotThrow(() -> createRandomChannel()).getChannel();
    String text = "This is a message";
    MessageRequestObject messageRequest =
        MessageRequestObject.builder().withText(text).withUserId(serverUser.getId()).build();
    Message message =
        Assertions.assertDoesNotThrow(
                () ->
                    Message.send(channel.getType(), channel.getId())
                        .withMessage(messageRequest)
                        .request())
            .getMessage();
    Assertions.assertEquals(text, message.getText());
  }

  @DisplayName("Can update a message")
  @Test
  void whenUpdatingAMessage_thenNoException() {
    Channel channel = Assertions.assertDoesNotThrow(() -> createRandomChannel()).getChannel();
    String text = "This is a message";
    MessageRequestObject messageRequest =
        MessageRequestObject.builder().withText(text).withUserId(serverUser.getId()).build();
    Message message =
        Assertions.assertDoesNotThrow(
                () ->
                    Message.send(channel.getType(), channel.getId())
                        .withMessage(messageRequest)
                        .request())
            .getMessage();
    String updatedText = "This is an updated message";
    MessageRequestObject updatedMessageRequest =
        MessageRequestObject.builder().withText(updatedText).withUserId(serverUser.getId()).build();
    Message updatedMessage =
        Assertions.assertDoesNotThrow(
                () -> Message.update(message.getId()).withMessage(updatedMessageRequest).request())
            .getMessage();
    Assertions.assertEquals(updatedText, updatedMessage.getText());
  }

  @DisplayName("Can search messages with no exception and retrieve given message")
  @Test
  void whenSearchingMessages_thenNoExceptionAndRetrievesMessage() {
    Channel channel = Assertions.assertDoesNotThrow(() -> createRandomChannel()).getChannel();
    String text = "This is a message";
    MessageRequestObject messageRequest =
        MessageRequestObject.builder().withText(text).withUserId(serverUser.getId()).build();
    Assertions.assertDoesNotThrow(
        () ->
            Message.send(channel.getType(), channel.getId()).withMessage(messageRequest).request());
    Map<String, Object> channelConditions = new HashMap<>();
    channelConditions.put("id", channel.getId());
    Map<String, Object> messageConditions = new HashMap<>();
    messageConditions.put("text", text);
    List<SearchResult> searchResults =
        Assertions.assertDoesNotThrow(
                () ->
                    Message.search()
                        .withFilterConditions(channelConditions)
                        .withMessageFilterConditions(messageConditions)
                        .request())
            .getResults();
    Assertions.assertEquals(1, searchResults.size());
  }

  @DisplayName("Can upload txt file with no exception")
  @Test
  void whenUploadingTxtFile_thenNoException() {
    Assertions.assertDoesNotThrow(
        () ->
            App.update()
                .withFileUploadConfig(
                    FileUploadConfigRequestObject.builder()
                        .withAllowedFileExtensions(Collections.emptyList())
                        .build())
                .request());
    Channel channel = Assertions.assertDoesNotThrow(() -> createRandomChannel()).getChannel();
    Assertions.assertDoesNotThrow(
        () ->
            Message.uploadFile(channel.getType(), channel.getId(), serverUser.getId())
                .withFile(
                    new File(getClass().getClassLoader().getResource("upload_file.txt").getFile()))
                .withContentType("text/plain")
                .request());
  }

  @DisplayName("Can upload pdf file with no exception")
  @Test
  void whenUploadingPdfFile_thenNoException() {
    Assertions.assertDoesNotThrow(
        () ->
            App.update()
                .withFileUploadConfig(
                    FileUploadConfigRequestObject.builder()
                        .withAllowedFileExtensions(Collections.emptyList())
                        .build())
                .request());
    Channel channel = Assertions.assertDoesNotThrow(() -> createRandomChannel()).getChannel();
    Assertions.assertDoesNotThrow(
        () ->
            Message.uploadFile(channel.getType(), channel.getId(), serverUser.getId())
                .withFile(
                    new File(getClass().getClassLoader().getResource("upload_file.pdf").getFile()))
                .request());
  }

  @DisplayName("Can upload svg image with no exception")
  @Test
  void whenUploadingSvgImage_thenNoException() {
    Assertions.assertDoesNotThrow(
        () ->
            App.update()
                .withImageUploadConfig(
                    FileUploadConfigRequestObject.builder()
                        .withAllowedFileExtensions(Collections.emptyList())
                        .build())
                .request());
    Channel channel = Assertions.assertDoesNotThrow(() -> createRandomChannel()).getChannel();
    Assertions.assertDoesNotThrow(
        () ->
            Message.uploadImage(
                    channel.getType(), channel.getId(), serverUser.getId(), "image/svg+xml")
                .withFile(
                    new File(getClass().getClassLoader().getResource("upload_image.svg").getFile()))
                .request());
  }

  @DisplayName("Can upload png image to resize with no exception")
  @Test
  void whenUploadingPngImage_thenNoException() {
    Assertions.assertDoesNotThrow(
        () ->
            App.update()
                .withImageUploadConfig(
                    FileUploadConfigRequestObject.builder()
                        .withAllowedFileExtensions(Collections.emptyList())
                        .build())
                .request());
    Channel channel = Assertions.assertDoesNotThrow(() -> createRandomChannel()).getChannel();
    Assertions.assertDoesNotThrow(
        () ->
            Message.uploadImage(channel.getType(), channel.getId(), serverUser.getId(), "image/png")
                .withFile(
                    new File(getClass().getClassLoader().getResource("upload_image.png").getFile()))
                .withUploadSizes(
                    Arrays.asList(
                        ImageSizeRequestObject.builder()
                            .withCrop(Crop.TOP)
                            .withResize(Resize.SCALE)
                            .withHeight(200)
                            .withWidth(200)
                            .build()))
                .request());
  }
}
