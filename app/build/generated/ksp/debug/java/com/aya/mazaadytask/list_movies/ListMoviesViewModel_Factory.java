package com.aya.mazaadytask.list_movies;

import com.aya.data.repository.MovieRepositoryImpl;
import com.aya.mazaadytask.ui.list_movies.ListMoviesViewModel;

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
public final class ListMoviesViewModel_Factory implements Factory<ListMoviesViewModel> {
  private final Provider<MovieRepositoryImpl> repoProvider;

  public ListMoviesViewModel_Factory(Provider<MovieRepositoryImpl> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public ListMoviesViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static ListMoviesViewModel_Factory create(Provider<MovieRepositoryImpl> repoProvider) {
    return new ListMoviesViewModel_Factory(repoProvider);
  }

  public static ListMoviesViewModel newInstance(MovieRepositoryImpl repo) {
    return new ListMoviesViewModel(repo);
  }
}
