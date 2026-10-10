# Flags of the World Quiz

An Android flash-card app, written in Kotlin, that helps you learn world flags.
Each time the app launches, it randomly selects 10 unique flags from a set of
224 and cycles through them. Each flag is shown with the prompt "What Flag Is
This?" for 5 seconds, then the country name is revealed for 5 seconds before the
next flag appears. The loop repeats until the user leaves the app.

Built for a mobile app development course.

## How it works

- **`Quizflag`** extends `Thread` and runs the quiz loop. It picks the flags
  using a `LinkedHashSet` so there are no duplicates, then alternates between
  the prompt and the answer for each flag. It stops cleanly when interrupted.
- **`QuizHandler`** is a `Runnable` that updates the `ImageView` and `TextView`.
  The quiz thread posts it to the main thread's `Handler`, so the UI is only
  touched from the UI thread.
- **`MainActivity`** sets up the layout, creates the quiz (5 seconds per screen,
  10 flags), and starts it.

## Built with

- Kotlin
- Android Studio
- Android SDK (`Thread`, `Handler`, `Runnable`, `ImageView`, `TextView`)

## Running the app

1. Clone the repo and open it in Android Studio.
2. Add the flag images (see below).
3. Run on an emulator or a connected device.

## Flag images

The flag images (`.bmp` files) were provided by the course instructor and are
not included in this repository. The app expects one image per country, named in
lowercase with underscores (for example, `united_states_of_america.bmp`).

## Author

Trey Rajsombath
