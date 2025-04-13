package com.aya.mazaadytask.movie_details;

import com.aya.data.repository.MovieRepositoryImpl;
import com.aya.mazaadytask.ui.movie_details.MovieDetailsViewModel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DetailsMovieViewModel_Factory implements Factory<MovieDetailsViewModel> {
  private final Provider<MovieRepositoryImpl> repoProvider;

  public DetailsMovieViewModel_Factory(Provider<MovieRepositoryImpl> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MovieDetailsViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static DetailsMovieViewModel_Factory create(Provider<MovieRepositoryImpl> repoProvider) {
    return new DetailsMovieViewModel_Factory(repoProvider);
  }

  public static MovieDetailsViewModel newInstance(MovieRepositoryImpl repo) {
    return new MovieDetailsViewModel(repo);
  }
}
