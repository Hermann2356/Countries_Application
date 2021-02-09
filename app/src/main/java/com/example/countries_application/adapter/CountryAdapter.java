package com.example.countries_application.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries_application.databinding.ItemImageBinding;
import com.example.countries_application.model.Country;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private final List<Country> countries;
    private CountryClickListener listener;

    public CountryAdapter(List<Country> countries, CountryClickListener listener) {
        this.countries = countries;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemImageBinding binding = ItemImageBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new CountryViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.setImage(country);
        holder.setOnClick(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        private ItemImageBinding binding;
        private CountryClickListener listener;


        public CountryViewHolder(@NonNull ItemImageBinding binding, CountryClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
        }

        public void setImage(@NotNull Country country) {
//            GlideToVectorYou.justLoadImage((SearchActivity) binding.getRoot()
//                    .getContext(), Uri.parse(country.getFlag()), binding.ivCountry);
//
//            GlideApp.with(this)
//                    .load(url)
//                    .into(picto_view)
        }

        private void setOnClick(Country country) {
            binding.getRoot().setOnClickListener(v -> {
                if (listener != null) {
                    listener.itemClicked(country);
                }
            });
        }
    }
}
