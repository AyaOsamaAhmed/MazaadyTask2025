package com.aya.mazaadytask.detailsMovie;

import com.aya.data.repository.MovieRepositoryImpl;
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
public final class DetailsMovieViewModel_Factory implements Factory<DetailsMovieViewModel> {
  private final Provider<MovieRepositoryImpl> repoProvider;

  public DetailsMovieViewModel_Factory(Provider<MovieRepositoryImpl> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public DetailsMovieViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static DetailsMovieViewModel_Factory create(Provider<MovieRepositoryImpl> repoProvider) {
    return new DetailsMovieViewModel_Factory(repoProvider);
  }

  public static DetailsMovieViewModel newInstance(MovieRepositoryImpl repo) {
    return new DetailsMovieViewModel(repo);
  }
}
