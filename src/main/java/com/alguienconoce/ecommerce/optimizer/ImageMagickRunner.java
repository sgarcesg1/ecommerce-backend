package com.alguienconoce.ecommerce.optimizer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class ImageMagickRunner {

    private static final String BACKGROUND_COLOR = "rgb(245,245,245)";

    private Path originalFilePath;
    private Path destinationFilePath;
    private Optional<String> resize;
    private Optional<Integer> quality;
    private Optional<String> gravity;
    private Optional<String> extent;

    private void optimize() {
        Objects.requireNonNull(originalFilePath, "Source file must be specified");
        Objects.requireNonNull(destinationFilePath, "Destination file must be specified");

        final List<String> command = new ArrayList<>();
        command.add("magick");
        command.add("convert");

        command.add(originalFilePath.toAbsolutePath().toString());

        resize.ifPresent(param -> {
            command.add("-quality");
            command.add(param);
        });

        resize.ifPresent(param -> {
            command.add("-resize");
            command.add(param);
        });

        gravity.ifPresent(param -> {
            command.add("-gravity");
            command.add(param);
        });

        extent.ifPresent(param -> {
            command.add("-extent");
            command.add(param);
            command.add("-background");
            command.add(BACKGROUND_COLOR);
        });

        command.add(destinationFilePath.toAbsolutePath().toString());
        try {
            log.info("Running command: {}", String.join(" ", command));
            Process process = new ProcessBuilder(command).start();
            boolean exit = process.waitFor(5, TimeUnit.SECONDS);
            log.info("Command finished with status: {}", exit);
            if (!Files.exists(destinationFilePath)) {
                throw new RuntimeException("Fail processing image.");
            }
        } catch (IOException | InterruptedException e) {
            log.error("Error running command", e);
            throw new RuntimeException("Fail processing image.");
        }
    }
}
